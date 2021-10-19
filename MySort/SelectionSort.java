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
        In in = new In("C:\\Users\\nguye\\IdeaProjects\\algs4\\algs4-data\\1Kints.txt");
        int[] arr = in.readAllInts();
        int n = arr.length;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = arr[i];
        long start = System.currentTimeMillis();
        selectionSort(a);
        long end = System.currentTimeMillis();
        for (int i = 0; i < n; i++) StdOut.println(a[i]);
        StdOut.println(end - start);
    }

}

// Ý tưởng: tìm phần tử nhỏ nhất trong đoạn chưa sắp xếp và đổi chỗ nó với phần tử đầu của đoạn chưa sắp xếp

// O(N2)

// Not stability
