import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestHashTables {
    public static void main(String[] args) {
        //SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys()) StdOut.println(s + " " + st.get(s));
    }
}
