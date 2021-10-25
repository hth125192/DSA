import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindMedian {
    private static int partition(List<Integer> a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (a.get(++i) < a.get(lo))
                if (i == hi) break;
            while (a.get(lo) < a.get(--j))
                if (j == lo) break;
            if (i >= j) break;
            Integer temp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
        }
        Integer temp = a.get(lo);
        a.set(lo, a.get(j));
        a.set(j, temp);
        return j;
    }

    private static int findMedian(List<Integer> arr, int lo, int hi) {
        int n = arr.size();
        int p = partition(arr, lo, hi);
        while (p != n / 2) {
            if (p > n / 2) p = partition(arr, lo, p - 1);
            else p = partition(arr, p + 1, hi);
        }
        return arr.get(p);
    }

    public static int findMedian(List<Integer> arr) {
        //Collections.sort(arr);
        //return arr.get(arr.size() / 2);
        return findMedian(arr, 0, arr.size() - 1);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) arr.add(scanner.nextInt());
        System.out.println(findMedian(arr));
    }
}
