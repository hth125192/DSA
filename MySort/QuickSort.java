import edu.princeton.cs.algs4.*;

public class QuickSort {
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo]))
                if (i == hi) break;
            while (less(a[lo], a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void quickSort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
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
        In in = new In("C:\\Users\\nguye\\IdeaProjects\\algs4\\algs4-data\\1Mints.txt");
        int[] arr = in.readAllInts();
        int n = arr.length;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = arr[i];
        long start = System.currentTimeMillis();
        quickSort(a);
        long end = System.currentTimeMillis();
        for (int i = 0; i < n; i++) StdOut.println(a[i]);
        StdOut.println(end - start);
    }

}

// Ý tưởng: phân vùng mảng sao cho 1 phần tử ở đúng vị trí rồi sort 2 bên

// O(NlogN)

// Not stability
