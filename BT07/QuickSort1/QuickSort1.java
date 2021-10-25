import java.util.ArrayList;
import java.util.List;

public class QuickSort1 {
    public static List<Integer> quickSort(List<Integer> arr) {
        int p = arr.get(0);
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> equal = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        for (Integer i : arr) {
            if (i < p) left.add(i);
            else if (i == p) equal.add(i);
            else right.add(i);
        }
        left.addAll(equal);
        left.addAll(right);
        return left;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(5, 7, 3, 1, 10, 4);
        List<Integer> key = quickSort(arr);
        for (int i = 0; i < key.size(); i++) System.out.print(key.get(i) + " ");
    }
}
