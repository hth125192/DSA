import java.util.List;

public class SherlockAndArray {
    public static String balancedSums(List<Integer> arr) {
        int leftSum = 0, rightSum = 0;
        for (int i : arr) rightSum += i;
        for (int i : arr) {
            rightSum -= i;
            if (leftSum == rightSum) return "YES";
            leftSum += i;
        }
        return "NO";
    }

    public static void main(String []args) {
        List<Integer> list = List.of(1);
        System.out.println(balancedSums(list));
    }

}
