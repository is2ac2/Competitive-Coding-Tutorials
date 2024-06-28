

package Java.Input_Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
