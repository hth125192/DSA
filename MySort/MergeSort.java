import edu.princeton.cs.algs4.*;

public class MergeSort {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) aux[k] = a[k];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        if (!less(a[mid+1], a[mid])) return;
        merge(a, aux, lo, mid, hi);
    }

    public static void mergeSort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void mergeBUSort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)
            for (int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        In in = new In("C:\\Users\\nguye\\IdeaProjects\\algs4\\algs4-data\\1Mints.txt");
        int[] arr = in.readAllInts();
        int n = arr.length;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = arr[i];
        long start = System.currentTimeMillis();
        //mergeSort(a);
        mergeBUSort(a);
        long end = System.currentTimeMillis();
        for (int i = 0; i < n; i++) StdOut.println(a[i]);
        StdOut.println(end - start);
    }

}

// Ý tưởng: đệ quy chia mảng làm 2 nửa, sắp xếp 2 nửa (sort) và gộp 2 nửa đã sắp xếp (merge)

// O(NlogN)

// Stability (not stability khi lấy bên phải trong trường hợp bằng)
