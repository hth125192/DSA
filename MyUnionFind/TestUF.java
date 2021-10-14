import edu.princeton.cs.algs4.*;

public class TestUF {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        ImprovementUF uf = new ImprovementUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
    }
}

//javac -cp C:\Users\nguye\IdeaProjects\algs4\algs4.jar;. TestUF.java
//java -cp C:\Users\nguye\IdeaProjects\algs4\algs4.jar;. TestUF < C:\Users\nguye\IdeaProjects\algs4\algs4-data\tinyUF.txt
