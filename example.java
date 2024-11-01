
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;

/*
 * This is a template for Java code that uses the 
 * FastScanner class to read input from files, and 
 * PrintWriter to write output to files. 
 * 
 * In most questions for competitive programming, such as
 * CodeForces, ICPC, and others, the input and output
 * is in the form of files.  
 */
public class example {
    public static void main(String[] args) {

        // Scanner object to read input from files
        FastScanner fs = new FastScanner();

        // Printer to write output to files
        PrintWriter pw = new PrintWriter(System.out);

        // Reads number of test cases in the input
        // If there is only one test case, you can set `int t = 1
        int t = fs.ni();
        

        // For each test case your code should take in the appropriate outputs
        // and print the output, the answer, in the proper format
        for (int tc = 1; tc <= t; tc++) {

            // ni() -> reads the next integer in the file
            // (next integer)
            int n = fs.ni();

            // intArray(n) -> reads the next n integers and puts them in an array
            int[] a = fs.intArray(n);
            
            // nd() -> reads the next double in the file
            // next double
            double d = fs.nd();

            // nl() -> reads the next long in the file
            // next long
            long l = fs.nl();

            // next() -> reads the next string in the file, ex. "Hello"
            String s = fs.next();
            
            // nextLine() -> reads the next line in the file, ex. "Hello World"
            String nl = fs.nextLine();
           

            pw.println(a);
            pw.println(d);
            pw.println(s);
            pw.println(l);
            pw.println(nl);
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
