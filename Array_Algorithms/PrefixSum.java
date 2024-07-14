package Array_Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;

class example {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
        int t = fs.ni();
        for (int tc = 1; tc <= t; tc++) {
            // n -> the length of the array
            int n = fs.ni();
            //  a -> the array of integers
            int[] a = fs.intArray(n);
            // num_queries -> number of queries (l,r) what is the sum of the elements from l to r
            int num_queries = fs.ni();
            int[][] queries = new int[num_queries][2];
            // queries -> 2d array to store the queries [[l1,r1],[l2,r2],...]
            for (int i = 0; i < num_queries; i++) {
                queries[i][0] = fs.ni();
                queries[i][1] = fs.ni();
            }
            // p -> prefix sum array, where p[i] = a[0] + a[1] + ... + a[i]
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = a[i];
                if (i > 0) p[i] += p[i - 1];
            }

            // now to answer the queries, we can use the prefix sum array
            // the sum of the elements from l to r is p[r] - p[l-1]

            for (int i = 0; i < num_queries; i++) {
                // l -> left bound of the query
                // r -> right bound of the query
                int l = queries[i][0];
                int r = queries[i][1];

                // sum of the elements from l to r
                // if l = 0, then we just take p[r]
                int sum;
                if (l == 0) {
                    sum = p[r];
                } else {
                    sum = p[r] - p[l - 1];
                }
                
                // print the sum for this query
                pw.println(sum);
            }
        }
        pw.close();
    }
}
class FastScanner {
 
    BufferedReader br;
    StringTokenizer st;
 
    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in), 32768);
        st = null;
    }
 
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    Integer nexti () {
        if (st == null || !st.hasMoreElements()) return null;
        return Integer.parseInt(next());
    }
    int ni() {
        return Integer.parseInt(next());
    }
 
    int[] intArray(int N) {
        int[] ret = new int[N];
        for (int i = 0; i < N; i++) {
            ret[i] = ni();
        }
        return ret;
    }
 
    long nl() {
        return Long.parseLong(next());
    }
 
    long[] longArray(int N) {
        long[] ret = new long[N];
        for (int i = 0; i < N; i++) {
            ret[i] = nl();
        }
        return ret;
    }
 
    double nd() {
        return Double.parseDouble(next());
    }
 
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
