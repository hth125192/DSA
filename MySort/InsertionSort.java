import edu.princeton.cs.algs4.*;

public class InsertionSort {
    public static void insertionSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0; j--)
                if (less(a[j], a[j-1])) exch(a, j, j-1);
                else break;
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
        In in = new In("C:\\Users\\nguye\\IdeaProjects\\algs4\\algs4-data\\1Kints.txt");
        int[] arr = in.readAllInts();
        int n = arr.length;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = arr[i];
        long start = System.currentTimeMillis();
        insertionSort(a);
        long end = System.currentTimeMillis();
        for (int i = 0; i < n; i++) StdOut.println(a[i]);
        StdOut.println(end - start);
    }

}

// Ý tưởng: chèn từng phần tử vào vị trí đúng của nó trong phần mảng đã sắp xếp

// O(N2)

// Stability
