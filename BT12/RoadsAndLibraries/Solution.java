import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static ArrayList<ArrayList<Integer>> cities;
    public static boolean[] visited;

    public static long roadsAndLibraries(int n, int c_lib, int c_road) {
        if (c_lib < c_road) return (long) n * c_lib;
        long cost = 0;
        for (int i = 1; i < n + 1; i++)
            if (!visited[i]) cost += (countConnected(i, 1) - 1) * c_road + c_lib;
        return cost;
    }

    private static long countConnected(int i, long count) {
        visited[i] = true;
        for (int j : cities.get(i))
            if (!visited[j]) count = countConnected(j, count + 1);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; q++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int c_lib = scanner.nextInt();
            int c_road = scanner.nextInt();
            cities = new ArrayList<>();
            visited = new boolean[N + 2];
            for (int j = 1; j <= N + 1; j++) {
                cities.add(new ArrayList<>());
                visited[j] = false;
            }
            for (int j = 0; j < M; j++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                cities.get(v).add(w);
                cities.get(w).add(v);
            }
            System.out.println(roadsAndLibraries(N, c_lib, c_road));
        }
    }
}