import java.util.*;

public class MissingNumbersCountingSort {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        List<Integer> list = new ArrayList<>(100);
        int start = Collections.min(brr);
        for (int i = 0; i < 100; i++) list.add(0);
        for (Integer i : brr) list.set(i - start, list.get(i - start) + 1);
        for (Integer i : arr)
            if (start <= i && i < start + 100) list.set(i - start, list.get(i - start) - 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            if (list.get(i) > 0) result.add(i + start);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(scanner.nextInt());
        int m = scanner.nextInt();
        List<Integer> brr = new ArrayList<>();
        for (int i = 0; i < m; i++) brr.add(scanner.nextInt());
        List<Integer> result = missingNumbers(arr, brr);
        System.out.println(result);
    }
}
