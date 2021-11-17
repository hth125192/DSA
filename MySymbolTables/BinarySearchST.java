import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private int N = 0;
    private Key[] keys;
    private Value[] vals;

    public BinarySearchST() {
        keys = (Key[]) new Comparable[2];
        vals = (Value[]) new Object[2];
    }

    private void resize(int capacity) {
        Key[] tempk = (Key[]) new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        keys = tempk;
        vals = tempv;
    }

    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        if (N == keys.length) resize(2 * keys.length);
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    private int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (isEmpty()) return;
        int r = rank(key);
        if (r == N || keys[r].compareTo(key) != 0) return;
        for (int i = r; i < N - 1; i++) {
            keys[i] = keys[i + 1];
            vals[i] = vals[i + 1];
        }
        N--;
        keys[N] = null;
        vals[N] = null;
        if (N > 0 && N == keys.length / 4) resize(keys.length / 2);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (int i = 0; i < N; i++) q.enqueue(keys[i]);
        return q;
    }
}
