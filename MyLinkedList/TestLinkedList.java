public class TestLinkedList {
    public static void test(MyLinkedList<String> list) {
        list.print();
        list.addLast("One");
        list.addFirst("Two");
        list.print();
        list.addLast("Three");
        list.print();
        list.print();
    }
    public static void main(String []args) {
        SinglyLinkedList<String> sList = new SinglyLinkedList<>();
        test(sList);

        DoublyLinkedList<String> dList = new DoublyLinkedList<>();
        test(dList);
    }
}
