package Graph_Algorithms.UnionFind;

import java.util.*;

public class UnionFindExample {
    public static void main(String[] args) {
        int n = 5;
        UnionFind uf = new UnionFind(n);
        uf.union(0, 1);
        uf.union(3, 2);
        uf.union(4, 1);
        uf.union(4, 2);
        int root = uf.find(2);
        int size = uf.size(root);
        System.out.println(size);
        System.out.println(Arrays.toString(uf.id));
    }
}

class UnionFind {
    int[] id;
    int[] sz;

    // Constructor
    // id[i] -> the parent of each element (i)
    // sz[i] -> the size of a set with root (i)
    public UnionFind (int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            // the root of each element begins as itself
            id[i] = i;
            // size of each set begins at 1
            sz[i] = 1;
        }
    }

    // Find the root/ (set index) of element p
    public int find (int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        while (p!=root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    // Given a root, what is the size of its set?
    public int size(int p) {
        return sz[p];
    }

    // Performs a union between two elements 
    public void union(int p, int q) {
        int a = find(p),b = find(q);
        if (a==b) return;
        int s = size(a) + size(b);
        id[b] = a;
        sz[a] = s;
        sz[b] = s;
    }
}

