import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        int count = 0;
        for (int i = q.size(); i > 0; i--) {
            if (q.get(i - 1) != i) {
                if (i - 1 > 0 && q.get(i - 2) == i) {
                    count++;
                    Collections.swap(q, i - 2, i - 1);
                } else if (i - 2 > 0 && q.get(i - 3) == i) {
                    count += 2;
                    Collections.swap(q, i - 3, i - 2);
                    Collections.swap(q, i - 2, i - 1);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String []args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(8);
        list.add(6);
        list.add(7);
        minimumBribes(list);
    }

}
