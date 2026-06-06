import sys
import subprocess

from kazoo import client
from kazoo.client import KazooClient, KazooState
from kazoo.exceptions import NoNodeError
from kazoo.protocol.states import EventType

# Globals
zk = None
proc = None
znode_name = ''
exec_args = ''

# CMD commands parsing
def get_cmd_args():
    if len(sys.argv) != 4:
        print(f'Error, usage: python3 main.py <host>:<port> <nodeName> <execPath>')
        raise Exception('Incorrect CMD params')

    global zk, znode_name, exec_args

    zk = KazooClient(hosts=sys.argv[1])
    znode_name = sys.argv[2]
    exec_args = sys.argv[3]

    return zk, znode_name, exec_args

# Parse while first scanning this module
get_cmd_args()

# Listener for zookeeper events
def zk_listener(state):
    if state == KazooState.LOST:
        print('Zookeeper connection lost!')
    elif state == KazooState.SUSPENDED:
        print('Zookeeper connection suspended!')
    else:
        print('Zookeeper connected!')

# Count all descendants
def get_num_descendants(path):
    children = zk.get_children(path)
    total_children = len(children)

    for child in children:
        total_children += get_num_descendants(path + '/' + child)

    return total_children

# Watch node children
def children_watcher(children, event):
    if event is None:
        return
    
    for c in children:
        zk.ChildrenWatch(event.path + '/' + c, children_watcher, send_event=True)
    
    path = '/' + znode_name
    print(f'Node {path} has {get_num_descendants(path)} descendants (event {event})')

# Init children watcher
def init_children_watcher(node_path):
    zk.ChildrenWatch(node_path, children_watcher, send_event=True)

# Terminate exec process
def kill_exec_process():
    global proc
    if not proc or proc.poll() is not None:
        print('Exec process already dead')
    else:
        print('Killing exec process')
        proc.terminate()

# Handler
@client.DataWatch(zk, '/' + znode_name)
def node_watcher(data, stat, event):
    if not event:
        return
    
    if event.type == EventType.CREATED:
        print(f'Created node {event.path}, running process {exec_args}')

        global proc
        proc = subprocess.Popen(exec_args)
        
        zk.ChildrenWatch('/' + znode_name, children_watcher, send_event=True)
    
    elif event.type == EventType.DELETED:
        print(f'Deleted node {event.path}')
        kill_exec_process()

# Main program
def main():
    zk.add_listener(zk_listener)
    zk.start()

    znode_path = '/' + znode_name
    if zk.exists(znode_path):
        init_children_watcher(znode_path)

    while True:
        try: line = input().strip()
        except: break

        if line == 'quit':
            break
        elif line == 'tree':
            tree = []
            stack = [znode_name]

            while stack:
                current = stack.pop()

                try:
                    children = zk.get_children(current)
                except NoNodeError:
                    print(f'node {current} missing!')
                    continue
            
                for child in children:
                    stack.append(f'{current}/{child}')
                
                tree.append(current)

            for tree_part in tree:
                print(f'{'   ' * tree_part.count('/')}- {tree_part.split('/')[-1]}')    

    zk.stop()
    kill_exec_process()

if __name__ == "__main__":
    main()
