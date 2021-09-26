import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class ThreeSum {
    public static void checkThree(int[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length-2; i++)
            for (int j = i+1; j < a.length-1; j++) {
                int k = Arrays.binarySearch(a, j+1, a.length, -(a[i] + a[j]));
                if (k > 0) StdOut.println(a[i] + " " + a[j] + " " + a[k]);
            }
    }

    public static void main(String []args) {
        In in = new In("C:\\Users\\nguye\\IdeaProjects\\algs4\\algs4-data\\1Kints.txt");
        int[] a = in.readAllInts();

        checkThree(a);
    }
}
