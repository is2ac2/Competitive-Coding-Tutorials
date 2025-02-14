package Array_Algorithms;
import java.util.*;

public class CustomSorting {
    public static void main(String[] args) {
        PriorityQueue<Integer> priority = new PriorityQueue(Comparator.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
        PriorityQueue<int[]> pq2 = new PriorityQueue<int[]>(new Comparator<int[]>(){
             public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int[]> list = new ArrayList();
        Collections.sort(list,new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int[][] two = new int[4][2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                two[i][j] = i + j;
            }
        }
        Arrays.sort(two,new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        Arrays.sort(two,(a,b)->(a[0]-b[0]));
        Arrays.sort(two,(a,b)->(a[0]==b[0]?a[1]-b[1]:b[0]-a[0]));
        pq2.add(new int[] {0,0});
        pq2.add(new int[] {1,1});
        pq.add(4);
        pq.add(3);
        System.out.println(Arrays.toString(pq2.poll()));
        System.out.println(pq.poll());
    }
}
