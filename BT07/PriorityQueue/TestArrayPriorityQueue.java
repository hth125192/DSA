public class TestArrayPriorityQueue {
    public static void main(String[] args) {
        ArrayPriorityQueue arr = new ArrayPriorityQueue();
        arr.print();

        arr.insert(7);
        arr.print();

        arr.insert(10);
        arr.insert(3);
        arr.print();

        arr.deleteMin();
        arr.print();

        arr.insert(1);
        arr.insert(7);
        arr.insert(5);
        arr.print();

        arr.deleteMin();
        arr.print();
    }
}
