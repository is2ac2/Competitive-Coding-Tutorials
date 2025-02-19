package Graph_Algorithms.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    public static void main(String[] args) {
        // example inputs
        int num_nodes = 4;
        int[][] pairs = {{0,1}, {0,2}, {0,3}, {2, 3}};

        Queue<Integer> prune = new LinkedList();
        // stores the nodes that have 0 incoming edges

        List<Integer> top_order = new ArrayList();
        // stores the final order of nodes in topological order

        List<List<Integer>> edges = new ArrayList();
        // Adjacency list for each node
        // edges[node] => list of all nodes that 'node' has an edge to

        int[] num_incoming_edges = new int[num_nodes]; 
        // for each node, the count of incoming nodes for that node
        
        // populate adjacency list
        for (int i = 0; i < num_nodes; i++) {
            List<Integer> temp = new ArrayList();
            edges.add(temp);
        }
        
        // create edges
        for (int i = 0; i < pairs.length; i++) {
            // there is requirement of visiting 'b' before 'a'
            edges.get(pairs[i][1]).add(pairs[i][0]);
            num_incoming_edges[pairs[i][0]]++;
        }
    
            for (int i = 0; i < num_nodes; i++) {
            // Add nodes with no incoming edges
                if (num_incoming_edges[i]==0) {
                prune.add(i);
            }
            }
        
        while (!prune.isEmpty()) {
            int node = prune.poll();
            top_order.add(node);
            List<Integer> outgoing = edges.get(node);
            for (int neighbor: outgoing) {
            //"prune" or take away nodes with no more incoming nodes.
            //think of this as fulfilling all requirements
                num_incoming_edges[neighbor]--;
                if (num_incoming_edges[neighbor]==0) {
                    prune.add(neighbor);
                }
            }
 		}

        System.out.println(top_order.toString());
        // Result: an array with topologiacal ordering
        // Note: If no ordering exists, the length of the array will be less than the number of nodes
    }
}
