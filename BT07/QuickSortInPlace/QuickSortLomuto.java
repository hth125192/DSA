import java.util.Scanner;

public class QuickSortLomuto {
    private static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo - 1;
        for (int j = lo; j <= hi; j++)
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        return i;
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int p = partition(a, lo, hi);
        print(a);
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    public static void quickSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        quickSort(a);
    }
}
