import java.util.*;

public class MissingNumbersHashTables {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Hashtable<Integer, Integer> ht = new Hashtable<>(100);
        for (Integer i : brr) ht.put(i, ht.getOrDefault(i, 0) + 1);
        for (Integer i : arr)
            if (ht.get(i) != 0) ht.put(i, ht.get(i) - 1);

        List<Integer> result = new ArrayList<>();
        for (Integer i : ht.keySet())
            if (ht.get(i) > 0) result.add(i);
        Collections.sort(result);
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
