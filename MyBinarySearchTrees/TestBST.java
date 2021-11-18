import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestBST {
    public static void main(String[] args) {
        //BST<String, Integer> st = new BST<String, Integer>();
        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys()) StdOut.println(s + " " + st.get(s));
    }
}
