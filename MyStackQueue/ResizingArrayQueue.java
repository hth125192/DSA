public class ResizingArrayQueue<Item> {
    private Item[] s;
    private int N = 0;
    private int head = 0;
    private int tail = 0;

    public ResizingArrayQueue() {
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        if (N == s.length) resize(2 * s.length);
        s[tail++] = item;
        if (tail == s.length) tail = 0;
        N++;
    }

    public Item dequeue() {
        Item item = s[head];
        s[N] = null;
        N--;
        head++;
        if (head == s.length) head = 0;
        if (N > 0 && N == s.length/4) resize(s.length/2);
        return item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) copy[i] = s[(head + i) % s.length];
        s = copy;
        head = 0;
        tail = N;
    }

}
