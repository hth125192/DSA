public class TestPriorityQueue {
    public static void main(String[] args) {
        MinPQ<String> pq = new MinPQ<String>(100);
        pq.print();

        pq.insert("P");
        pq.print();

        pq.insert("Q");
        pq.insert("E");
        pq.print();

        pq.delMin();
        pq.print();

        pq.insert("X");
        pq.insert("A");
        pq.insert("M");
        pq.print();

        pq.delMin();
        pq.print();

        pq.insert("P");
        pq.insert("L");
        pq.insert("E");
        pq.delMin();
        pq.print();
    }
}
