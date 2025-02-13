
from collections import deque

def main():
    
    # Python source code
    # follow along with comments on the java file
    num_nodes = 4
    pairs = [[0,1],[0,2], [0,3], [2,3]]
    
    prune = deque()
    top_order = []
    edges = {}
    for i in range(num_nodes):
        edges[i] = []
    num_incoming_edges = [0]*num_nodes

    for pair in pairs:
        edges[pair[1]].append(pair[0])
        num_incoming_edges[pair[0]]+=1
    
    for i in range(num_nodes):
        if (num_incoming_edges[i]==0):
            prune.append(i)

    while (len(prune)>0):
        node = prune.pop()
        top_order.append(node)
        outgoing = edges[node]
        for neighbor in outgoing:
            num_incoming_edges[neighbor]-=1
            if (num_incoming_edges[neighbor]==0):
                prune.append(neighbor)
    
    print(top_order)

if __name__ == '__main__':
    main()