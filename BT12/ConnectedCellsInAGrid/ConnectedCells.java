import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectedCells {
    public static int connectedCell(List<List<Integer>> matrix) {
        int maxConnectedCell = 0;
        for (int i = 0; i < matrix.size(); i++)
            for (int j = 0; j < matrix.get(i).size(); j++)
                if (matrix.get(i).get(j) == 1) maxConnectedCell = Math.max(maxConnectedCell, DFS(matrix, i, j));
        return maxConnectedCell;
    }

    private static int DFS(List<List<Integer>> matrix, int i, int j) {
        if (i < 0 || i >= matrix.size() || j < 0 || j >= matrix.get(i).size() || matrix.get(i).get(j) == 0) return 0;
        matrix.get(i).set(j, 0);
        int region = 1;
        for (int row = -1; row <= 1; row++)
            for (int col = -1; col <= 1; col++) region += DFS(matrix, i + row, j + col);
        return region;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < M; j++) row.add(scanner.nextInt());
            matrix.add(row);
        }
        System.out.println(connectedCell(matrix));
    }
}
