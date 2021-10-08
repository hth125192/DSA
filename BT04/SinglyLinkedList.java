public class SinglyLinkedList {
    SinglyLinkedListNode head;

    private static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if (head == null) {
            head = new SinglyLinkedListNode(data);
            return head;
        }
        SinglyLinkedListNode current = head;
        while (current.next != null) current = current.next;
        current.next = new SinglyLinkedListNode(data);
        return head;
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (llist != null) newNode.next = llist;
        return newNode;
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (llist == null) return newNode;
        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode pre = llist;
        int i = 0;
        while (current != null)
        {
            if (i == position) break;
            pre = current;
            current = current.next;
            i++;
        }
        pre.next = newNode;
        newNode.next = current;
        return llist;
    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        if (position == 0)
        {
            SinglyLinkedListNode newHead = llist.next;
            return newHead;
        }
        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode pre = llist;
        int i = 0;
        while (current != null)
        {
            if (i == position) break;
            pre = current;
            current = current.next;
            i++;
        }
        pre.next = current.next;
        return llist;
    }

    public static void reversePrint(SinglyLinkedListNode llist) {
        if (llist != null)
        {
            reversePrint(llist.next);
            System.out.println(llist.data);
        }
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        if (llist == null) return llist;
        SinglyLinkedListNode pre = llist;
        SinglyLinkedListNode current = llist.next;
        llist.next = null;
        while (current != null)
        {
            SinglyLinkedListNode tmpNode = current.next;
            current.next = pre;
            pre = current;
            current = tmpNode;
        }
        return pre;
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode node1 = head1;
        SinglyLinkedListNode node2 = head2;
        while (node1 != null || node2 != null)
        {
            if (node1 == null || node2 == null || node1.data != node2.data) return false;
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        SinglyLinkedListNode head;
        if (head1.data <= head2.data)
        {
            head = head1;
            head.next = mergeLists(head1.next, head2);
        } else {
            head = head2;
            head.next = mergeLists(head1, head2.next);
        }
        return head;
    }

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        if (llist == null) return -1;
        SinglyLinkedListNode check = llist;
        SinglyLinkedListNode current = llist;
        for (int i = 0; i < positionFromTail; i++) check = check.next;
        while (check.next != null)
        {
            check = check.next;
            current = current.next;
        }
        return current.data;
    }

    public static void main(String []args) {
        SinglyLinkedList sList = new SinglyLinkedList();
    }

}
