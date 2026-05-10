import threading
import argparse
import pika
import json
import uuid

EXCHANGE_NAME = 'space_system'

ROUTING_KEY_PEOPLE = 'order.people'
ROUTING_KEY_CARGO = 'order.cargo'
ROUTING_KEY_SATELLITE = 'order.satellite'
ROUTING_KEY_ACK = ''
ROUTING_KEY_INFO = 'info.'

QUEUE_ACK = ''
QUEUE_INFO = ''

def init():
    connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))

    channel = connection.channel()
    channel.exchange_declare(exchange=EXCHANGE_NAME, exchange_type='topic')

    return connection, channel

def get_name_from_cli():
    parser = argparse.ArgumentParser(prog='Space Agency CLI',
                                     description='CLI for controlling space agency requests',
                                     epilog='For more information visit agh.edu.pl')

    parser.add_argument('-n', '--name', help='required, name of controlled agency.')

    args = parser.parse_args()

    if args.name is None:
        parser.print_help()
        raise Exception("Agency must be given a name")
    
    global QUEUE_ACK, ROUTING_KEY_ACK, QUEUE_INFO
    
    QUEUE_ACK = args.name + '_ack'
    ROUTING_KEY_ACK = 'ack.' + args.name
    QUEUE_INFO = 'info_queue_' + args.name

    return args.name

def request(channel, key, name):
    final_message = json.dumps({'agency': name, 'type': key, 'id': str(uuid.uuid4())})
    channel.basic_publish(exchange=EXCHANGE_NAME, routing_key=key, body=final_message)

def request_people(channel, name):
    request(channel, ROUTING_KEY_PEOPLE, name)

def request_cargo(channel, name):
    request(channel, ROUTING_KEY_CARGO, name)

def request_satellite(channel, name):
    request(channel, ROUTING_KEY_SATELLITE, name)

def ack_callback(ch, method, properties, body):
    print(f"{body.decode()}\n==> ", end = '')
    ch.basic_ack(delivery_tag=method.delivery_tag)

def ack_thread():
    connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))

    channel = connection.channel()
    channel.exchange_declare(exchange=EXCHANGE_NAME, exchange_type='topic')

    channel.queue_declare(queue=QUEUE_ACK)
    channel.queue_bind(exchange=EXCHANGE_NAME, queue=QUEUE_ACK, routing_key=ROUTING_KEY_ACK)

    channel.queue_declare(queue=QUEUE_INFO)
    channel.queue_bind(exchange=EXCHANGE_NAME, queue=QUEUE_INFO, routing_key=ROUTING_KEY_INFO + 'agency')
    channel.queue_bind(exchange=EXCHANGE_NAME, queue=QUEUE_INFO, routing_key=ROUTING_KEY_INFO + 'all')

    channel.basic_consume(queue=QUEUE_ACK, on_message_callback=ack_callback, auto_ack=False)
    channel.basic_consume(queue=QUEUE_INFO, on_message_callback=ack_callback, auto_ack=False)

    channel.start_consuming()

def main():
    connection, channel = init()

    try:

        name = get_name_from_cli()

        threading.Thread(target=ack_thread, daemon=True).start()

        while True:
            cmd = input("==> ").strip()

            if cmd == "people":
                request_people(channel, name)
            elif cmd == "cargo":
                request_cargo(channel, name)
            elif cmd == "sat":
                request_satellite(channel, name)
            elif cmd == "help":
                print("========= COMMANDS =========")
                print(" - people")
                print(" - cargo")
                print(" - sat")
                print("============================")
            elif cmd == "exit":
                connection.close()
                break
            else:
                print("???")

    except KeyboardInterrupt as e:
        connection.close()

if __name__ == "__main__":
    main()
