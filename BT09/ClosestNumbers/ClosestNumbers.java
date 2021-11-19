import java.util.ArrayList;
import java.util.List;

public class ClosestNumbers {
    public static void merge(List<Integer> a, List<Integer> aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) aux.set(k, a.get(k));
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a.set(k, aux.get(j++));
            else if (j > hi) a.set(k, aux.get(i++));
            else if (aux.get(j) < aux.get(i)) a.set(k, aux.get(j++));
            else a.set(k, aux.get(i++));
        }
    }

    private static void sort(List<Integer> a, List<Integer> aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(List<Integer> a) {
        List<Integer> aux = new ArrayList<>(a);
        sort(a, aux, 0, a.size() - 1);
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        sort(arr);
        List<Integer> key = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            int difference = arr.get(i) - arr.get(i-1);
            if (difference == min) {
                key.add(arr.get(i-1));
                key.add(arr.get(i));
            } else if (difference < min) {
                min = difference;
                key.clear();
                key.add(arr.get(i-1));
                key.add(arr.get(i));
            }
        }
        return key;
    }

    public static void main(String []args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(0);
        list.add(8);
        list.add(4);
        list.add(9);
        List<Integer> key = closestNumbers(list);
        for (int i : key) System.out.print(i + " ");
    }
}