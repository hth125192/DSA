import java.util.List;

public class Result {
    public static int introTutorial(int V, List<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (V < arr.get(mid)) high = mid - 1;
            else if (V > arr.get(mid)) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(0, 1, 3, 4, 7, 10);
        System.out.println(introTutorial(4, arr));
    }
}
