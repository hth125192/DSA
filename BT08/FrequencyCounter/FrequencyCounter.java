import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FrequencyCounter {
    public static int findIndex(List<String> s, String word) {
        int lo = 0, hi = s.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (s.get(mid).compareTo(word) < 0) {
                if (lo == s.size() - 1) return lo;
                lo = mid + 1;
            }
            else if (s.get(mid).compareTo(word) > 0) hi = mid - 1;
            else return mid;
        }
        return lo;
    }

    public static void add(List<String> s, List<Integer> counts, String word) {
        if (s.size() == 0) {
            s.add(word);
            counts.add(1);
            return;
        }
        int index = findIndex(s, word);
        if (s.get(index).compareTo(word) == 0) {
            counts.set(index, counts.get(index) + 1);
            return;
        }
        if (s.get(index).compareTo(word) < 0) index++;
        s.add(s.get(s.size() - 1));
        counts.add(counts.get(counts.size() - 1));
        for (int i = s.size() - 2; i > index; i--) {
            s.set(i, s.get(i - 1));
            counts.set(i, counts.get(i - 1));
        }
        s.set(index, word);
        counts.set(index, 1);
    }

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.next();
            add(s, counts, word);
        }

        for (int i = 0; i < s.size(); i++) System.out.println(s.get(i) + ' ' + counts.get(i));
    }
}