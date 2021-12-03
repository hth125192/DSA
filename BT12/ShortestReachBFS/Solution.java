import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static boolean[] visited;

    public static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
        int[] costs = new int[graph.size()];
        int UNIT_COST = 6;
        for (int i = 0; i < costs.length; ++i) costs[i] = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        costs[start] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;
            for (int i = 0; i < graph.get(current).size(); i++) {
                int next = graph.get(current).get(i);
                if (!visited[next]) {
                    queue.add(next);
                    costs[next] = costs[current] + UNIT_COST;
                    visited[next] = true;
                }
            }
        }
        return costs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; ++q) {
            int N, M, start;
            N = scanner.nextInt();
            M = scanner.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            visited = new boolean[N + 2];
            for (int i = 1; i <= N + 1; ++i) {
                graph.add(new ArrayList<>());
                visited[i] = false;
            }
            for (int i = 0; i < M; ++i) {
                int n1, n2;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
            start = scanner.nextInt();
            int[] costs = findShortestReach(graph, start);
            for (int i = 1; i < costs.length; ++i) {
                if (i == start) continue;
                System.out.print(costs[i] + " ");
            }
            System.out.println();
        }
    }
}