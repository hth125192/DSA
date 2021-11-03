import java.util.*;

public class FindTheRunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Comparator.reverseOrder());

        List<Double> keys = new ArrayList<Double>();
        keys.add(a.get(0) * 1.0);
        maxPQ.add(a.get(0));

        for (int i = 1; i < a.size(); i++) {
            int number = a.get(i);

            if (number > maxPQ.peek()) minPQ.add(number);
            else maxPQ.add(number);

            if (minPQ.size() - maxPQ.size() > 1) maxPQ.add(minPQ.poll());
            else if (maxPQ.size() - minPQ.size() > 1) minPQ.add(maxPQ.poll());

            if (i % 2 == 0) {
                if (maxPQ.size() > minPQ.size()) keys.add(maxPQ.peek() * 1.0);
                else keys.add(minPQ.peek() * 1.0);
            } else keys.add((maxPQ.peek() + minPQ.peek()) * 0.5);
        }
        return keys;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) a.add(scanner.nextInt());
        List<Double> keys = runningMedian(a);
        for (int i = 0; i < n; i++) System.out.println(keys.get(i));
    }
}
