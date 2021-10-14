import edu.princeton.cs.algs4.*;

public class SelectionSort {
    public static void selectionSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(String.valueOf(1000));
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) a[i] = StdRandom.uniform();
        long start = System.currentTimeMillis();
        selectionSort(a);
        long end = System.currentTimeMillis();
        for (int i = 0; i < N; i++) StdOut.println(a[i]);
        StdOut.println(end - start);
    }

}