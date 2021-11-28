import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        int count = 0;
        Set<Integer> set = new HashSet<>(arr);
        for (Integer integer : arr)
            if (set.contains(integer + k)) count++;
        return count;
    }

    public static void main(String []args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) list.add(i);
        list.add(8);
        System.out.print(pairs(2, list));
    }

}