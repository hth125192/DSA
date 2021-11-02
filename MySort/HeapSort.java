import edu.princeton.cs.algs4.*;

public class HeapSort {
    public static void heapSort(Comparable[] a) {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--) sink(a, k, n);
        while (n > 1) {
            exch(a, 1, n);
            sink(a, 1, --n);
        }
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object tmp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = tmp;
    }

    public static void main(String[] args) {
        In in = new In("C:\\Users\\nguye\\IdeaProjects\\algs4\\algs4-data\\1Mints.txt");
        int[] arr = in.readAllInts();
        int n = arr.length;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = arr[i];
        long start = System.currentTimeMillis();
        heapSort(a);
        long end = System.currentTimeMillis();
        for (int i = 0; i < n; i++) StdOut.println(a[i]);
        StdOut.println(end - start);
    }

}

// Ý tưởng: sử dụng Binary heap để sắp xếp

// O(NlogN)

// Not stability
