import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String []args) {
        int N = StdIn.readInt();
        int key = 0;
        UF uf = new UF(N);
        while (uf.count() > 1 && !StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            key++;
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
        }

        if (uf.count() == 1) {
            StdOut.println(key);
        }
        else {
            StdOut.println("FAILED");
        }
    }
}
