import java.util.ArrayList;
import java.util.List;

public class CountingSort1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> key = new ArrayList<>();
        for (int i = 0; i < 100; i++) key.add(0);
        for (Integer in : arr) key.set(in, key.get(in) + 1);
        return key;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(0, 1, 3, 4, 7, 10);
        List<Integer> key = countingSort(arr);
        for (int i = 0; i < 100; i++) System.out.print(key.get(i) + " ");
    }
}
