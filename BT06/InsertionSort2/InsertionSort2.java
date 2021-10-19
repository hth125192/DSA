import java.util.ArrayList;
import java.util.List;

public class InsertionSort2 {
    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--)
                if (arr.get(j) < arr.get(j - 1)) {
                    Integer temp = arr.get(j);
                    arr.set(j, arr.get(j - 1));
                    arr.set(j - 1, temp);
                } else break;
            for (int j = 0; j < n - 1; j++) System.out.print(arr.get(j) + " ");
            System.out.println(arr.get(n - 1));
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        //arr.add(1);
        //arr.add(4);
        //arr.add(3);
        //arr.add(5);
        //arr.add(6);
        //arr.add(2);
        insertionSort2(0, arr);
    }

}
