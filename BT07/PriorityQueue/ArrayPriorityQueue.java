public class ArrayPriorityQueue {
    public static final int K = 10000;
    private final int[] a;
    private int N = 0;

    public ArrayPriorityQueue() {
        a = new int[K];
    }

    void insert(int i) {
        a[N++] = i;
    }

    int deleteMin() {
        int key = 0;
        for (int i = 1; i < N; i++)
            if (a[i] < a[key]) key = i;
        int tmp = a[key];
        a[key] = a[N - 1];
        N--;
        return tmp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void print() {
        for (int i = 0; i < N; i++) System.out.print(a[i] + " ");
        System.out.println();
    }
}
