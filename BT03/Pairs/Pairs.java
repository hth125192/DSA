import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        int count = 0;
        Collections.sort(arr);
        for (int i = 0; i < arr.size() - 1; i++) {
            int low = i + 1, high = arr.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr.get(i) + k < arr.get(mid)) high = mid - 1;
                else if (arr.get(i) + k > arr.get(mid)) low = mid + 1;
                else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String []args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) list.add(i);
        list.add(8);
        System.out.print(pairs(2, list));
    }

}
