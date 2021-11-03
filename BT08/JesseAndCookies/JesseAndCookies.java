import java.util.*;

public class JesseAndCookies {
    public static int cookies(int k, List<Integer> A) {
        int key = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < A.size(); i++) priorityQueue.add(A.get(i));
        while (priorityQueue.peek() < k && priorityQueue.size() > 1) {
            int m1 = priorityQueue.poll();
            int m2 = priorityQueue.poll();
            m2 = m1 + 2 * m2;
            priorityQueue.add(m2);
            key++;
        }
        if (priorityQueue.peek() >= k) return key;
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, K;
        N = scanner.nextInt();
        K = scanner.nextInt();
        List<Integer> A = new ArrayList<Integer>(N);
        for (int i = 0; i < N; i++) A.add(scanner.nextInt());
        System.out.println(cookies(K, A));
    }
}
