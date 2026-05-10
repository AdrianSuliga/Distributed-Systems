import threading
import datetime
import pika
import json

EXCHANGE_NAME = 'space_system'

QUEUE_ADMIN = 'admin_queue'

def init():
    connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))

    channel = connection.channel()
    channel.exchange_declare(exchange=EXCHANGE_NAME, exchange_type='topic')

    channel.queue_declare(queue=QUEUE_ADMIN)
    channel.queue_bind(exchange=EXCHANGE_NAME, queue=QUEUE_ADMIN, routing_key='#')

    return connection, channel

def post_info(channel, key, message):
    final_message = json.dumps({'type': 'admin_msg', 'msg': message})
    channel.basic_publish(exchange=EXCHANGE_NAME, routing_key=key, body=final_message)

def log_callback(ch, method, properties, body):
    print(f"[{datetime.datetime.now()}]: {body.decode()}\n==> ", end = '')

def log_thread():
    connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))

    channel = connection.channel()
    channel.exchange_declare(exchange=EXCHANGE_NAME, exchange_type='topic')

    channel.basic_consume(queue=QUEUE_ADMIN, on_message_callback=log_callback, auto_ack=True)
    channel.start_consuming()

def main():
    connection, channel = init()

    try:
        
        threading.Thread(target=log_thread, daemon=True).start()

        while True:
            line = input("==> ").strip().split(" ")
            cmd, args = line[0], line[1:]
            msg = ' '.join(args)

            if cmd in ["agency", "carrier", "all"]:
                post_info(channel, 'info.' + cmd, msg)
            elif cmd == "help":
                print("========= ADMIN =========")
                print(" - agency <msg>")
                print(" - carrier <msg>")
                print(" - all <msg>")
                print("=========================")
            elif cmd == "exit":
                connection.close()
                break
            else:
                print("???")

    except Exception as ex:
        pass

if __name__ == "__main__":
    main()
