import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class ThreeSumN2 {
    private ThreeSumN2() { }

    private static boolean containsDuplicates(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] == a[i-1]) return true;
        return false;
    }

    public static void printAll(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
        for (int i = 0; i < n - 2; i++) {
            int low = i + 1, high = n - 1;
            while (low < high) {
                if (a[low] + a[i] + a[high] == 0) {
                    System.out.println(a[low] + " " + a[i] + " " + a[high]);
                    low++;
                    high--;
                } else if (a[low] + a[i] + a[high] < 0) low++;
                else high--;
            }
        }
    }

    public static void main(String []args)  {
        In in = new In("C:\\Users\\nguye\\IdeaProjects\\algs4\\algs4-data\\1Kints.txt");
        int[] a = in.readAllInts();
        Stopwatch timer = new Stopwatch();
        printAll(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }

}
