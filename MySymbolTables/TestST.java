import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestST {
    public static void main(String[] args) {
        //SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys()) StdOut.println(s + " " + st.get(s));
    }
}
