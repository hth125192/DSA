import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestNumbers {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);
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
