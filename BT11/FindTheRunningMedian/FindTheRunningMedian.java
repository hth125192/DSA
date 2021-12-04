import java.util.*;

public class FindTheRunningMedian {
    private static class Node implements Comparable<Node> {
        double key;
        double value;

        public Node(double key, double value) {
            this.key = key;
            this.value = value;
        }

        public double getKey() {
            return key;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.key, o.key);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> results = new ArrayList<>();
        TreeSet<Node> treeSet = new TreeSet<>();
        Node runningMedian = new Node(a.get(0), 0);
        treeSet.add(runningMedian);
        results.add(runningMedian.getKey());
        for (int i = 1; i < a.size(); i++) {
            Node newNode = new Node(a.get(i), i);
            treeSet.add(newNode);
            if (treeSet.size() % 2 == 0) {
                if (newNode.compareTo(runningMedian) < 0) runningMedian = treeSet.lower(runningMedian);
                results.add((runningMedian.getKey() + treeSet.higher(runningMedian).getKey()) / 2);
            } else {
                if (newNode.compareTo(runningMedian) >= 0) runningMedian = treeSet.higher(runningMedian);
                results.add(runningMedian.getKey());
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) a.add(scanner.nextInt());
        List<Double> results = runningMedian(a);
        for (int i = 0; i < n; i++) System.out.println(results.get(i));
    }
}