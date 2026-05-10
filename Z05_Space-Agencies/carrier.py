import argparse
import pika
import json

EXCHANGE_NAME = 'space_system'

ROUTING_KEY_PEOPLE = 'order.people'
ROUTING_KEY_CARGO = 'order.cargo'
ROUTING_KEY_SATELLITE = 'order.satellite'
ROUTING_KEY_ACK = 'ack.'
ROUTING_KEY_INFO = 'info.'

QUEUE_PEOPLE = 'people_queue'
QUEUE_CARGO = 'cargo_queue'
QUEUE_SATELLITE = 'satellite_queue'
QUEUE_INFO = ''

CARRIER_NAME = ''

def init():
    connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
    channel = connection.channel()

    channel.exchange_declare(exchange=EXCHANGE_NAME, exchange_type='topic')

    channel.queue_declare(queue=QUEUE_PEOPLE)
    channel.queue_bind(exchange=EXCHANGE_NAME, queue=QUEUE_PEOPLE, routing_key=ROUTING_KEY_PEOPLE)

    channel.queue_declare(queue=QUEUE_CARGO)
    channel.queue_bind(exchange=EXCHANGE_NAME, queue=QUEUE_CARGO, routing_key=ROUTING_KEY_CARGO)

    channel.queue_declare(queue=QUEUE_SATELLITE)
    channel.queue_bind(exchange=EXCHANGE_NAME, queue=QUEUE_SATELLITE, routing_key=ROUTING_KEY_SATELLITE)

    channel.queue_declare(queue=QUEUE_INFO)
    channel.queue_bind(exchange=EXCHANGE_NAME, queue=QUEUE_INFO, routing_key=ROUTING_KEY_INFO + 'carrier')
    channel.queue_bind(exchange=EXCHANGE_NAME, queue=QUEUE_INFO, routing_key=ROUTING_KEY_INFO + 'all')

    return channel

def get_types_from_cli():
    parser = argparse.ArgumentParser(prog='Carrier script',
                                     description='Script for monitoring carrier activity',
                                     epilog='For more information visit agh.edu.pl')

    parser.add_argument('-n', '--name', help='required, name of the carrier')
    parser.add_argument('-p', '--people', action='store_true', help='if present, carrier supports people transport.')
    parser.add_argument('-c', '--cargo', action='store_true', help='if present, carrier supports cargo transport.')
    parser.add_argument('-s', '--satellite', action='store_true', help='if present, carrier supports satellite transportation')

    args = parser.parse_args()

    if args.name is None:
        raise Exception("Carrier must be given a name")

    global CARRIER_NAME, QUEUE_INFO
    CARRIER_NAME = args.name
    QUEUE_INFO = 'info_queue_' + args.name

    types = args.people, args.cargo, args.satellite

    if len([type for type in types if type]) != 2:
        raise Exception("Carrier must support exactly two services!")

    return args.people, args.cargo, args.satellite

def people_request_callback(ch, method, properties, body):
    request = json.loads(body.decode())

    print(f"Agency {request['agency']} requests people transport, order={request['id']}")
    ack_message = json.dumps({'type': 'ack', 'msg': f'{CARRIER_NAME} finished order {request['id']} for {request['agency']}'})

    ch.basic_publish(exchange=EXCHANGE_NAME, routing_key=ROUTING_KEY_ACK + request['agency'], body=ack_message)
    ch.basic_ack(delivery_tag=method.delivery_tag)

def cargo_request_callback(ch, method, propertes, body):
    request = json.loads(body.decode())

    print(f"Agency {request['agency']} requests cargo transport, order={request['id']}")
    ack_message = json.dumps({'type': 'ack', 'msg': f'{CARRIER_NAME} finished order {request['id']} for {request['agency']}'})

    ch.basic_publish(exchange=EXCHANGE_NAME, routing_key=ROUTING_KEY_ACK + request['agency'], body=ack_message)
    ch.basic_ack(delivery_tag=method.delivery_tag)

def satellite_request_callback(ch, method, properties, body):
    request = json.loads(body.decode())

    print(f"Agency {request['agency']} requests satellite transport, order={request['id']}")
    ack_message = json.dumps({'type': 'ack', 'msg': f'{CARRIER_NAME} finished order {request['id']} for {request['agency']}'})

    ch.basic_publish(exchange=EXCHANGE_NAME, routing_key=ROUTING_KEY_ACK + request['agency'], body=ack_message)
    ch.basic_ack(delivery_tag=method.delivery_tag)

def info_callback(ch, method, properties, body):
    print(f"{body.decode()}")

def main():
    people_support, cargo_support, satellite_support = get_types_from_cli()
    channel = init()

    if people_support:
        channel.basic_consume(queue=QUEUE_PEOPLE, on_message_callback=people_request_callback, auto_ack=False)

    if cargo_support:
        channel.basic_consume(queue=QUEUE_CARGO, on_message_callback=cargo_request_callback, auto_ack=False)

    if satellite_support:
        channel.basic_consume(queue=QUEUE_SATELLITE, on_message_callback=satellite_request_callback, auto_ack=False)

    channel.basic_consume(queue=QUEUE_INFO, on_message_callback=info_callback, auto_ack=True)

    try:
        channel.start_consuming()
    except KeyboardInterrupt as e:
        pass

if __name__ == "__main__":
    main()
