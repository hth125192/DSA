public class DoublyLinkedList<Item> implements MyLinkedList<Item> {
    Node header;
    Node trailer;

    public DoublyLinkedList() {
        this.header = new Node(null, null, null);
        this.trailer = new Node(null, header, null);
        header.next = trailer;
    }

    public void print() {
        Node current = header.next;
        System.out.print("[");
        while (current != trailer) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println("]");
    }

    public void addFirst(Item data) {
        insertAfter(data, header);
    }

    public void addLast(Item data) {
        insertAfter(data, trailer.prev);
    }

    private void insertAfter(Item data, Node node) {
        Node newNode = new Node(data, node, node.next);
        node.next = newNode;
        newNode.next.prev = newNode;
    }

    private class Node {
        Item data;
        Node prev;
        Node next;

        public Node(Item data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
