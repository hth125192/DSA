import java.util.*;

public class MissingNumbersSorting {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        List<Integer> result = new ArrayList<>();
        Collections.sort(arr);
        Collections.sort(brr);
        for (Integer i : arr)
            for (int j = 0; j < brr.size(); j++)
                if (Objects.equals(i, brr.get(j))) {
                    brr.remove(j);
                    break;
                }
        result.add(brr.get(0));
        for (int i = 1; i < brr.size(); i++)
            if (!Objects.equals(brr.get(i), brr.get(i - 1))) result.add(brr.get(i));
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
