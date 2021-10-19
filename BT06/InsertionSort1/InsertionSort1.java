import java.util.ArrayList;
import java.util.List;

public class InsertionSort1 {
    public static void insertionSort1(int n, List<Integer> arr) {
        if (n < 1) return;
        Integer key = arr.get(n - 1);
        int i = n - 2;
        while (i >= 0 && arr.get(i) > key) {
            arr.set(i + 1, arr.get(i));
            for (int j = 0; j < n - 1; j++) System.out.print(arr.get(j) + " ");
            System.out.println(arr.get(n - 1));
            i--;
        }
        arr.set(i + 1, key);
        for (i = 0; i < n - 1; i++) System.out.print(arr.get(i) + " ");
        System.out.println(arr.get(n - 1));
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        //arr.add(1);
        //arr.add(2);
        //arr.add(4);
        //arr.add(5);
        //arr.add(3);
        insertionSort1(0, arr);
    }

}
