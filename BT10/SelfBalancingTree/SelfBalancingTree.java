import java.util.Scanner;

public class SelfBalancingTree {
    private static class Node {
        public int val;
        public int ht;
        public Node left;
        public Node right;

        public Node() {
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node();
            root.val = val;
            root.ht = 0;
            return root;
        }
        if (val <= root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        int balance = height(root.left) - height(root.right);
        if (balance > 1) {
            if (height(root.left.left) >= height(root.left.right)) root = rightRotation(root);
            else {
                root.left = leftRotation(root.left);
                root = rightRotation(root);
            }
        } else if (balance < -1) {
            if (height(root.right.right) >= height(root.right.left)) root = leftRotation(root);
            else {
                root.right = rightRotation(root.right);
                root = leftRotation(root);
            }
        } else root.ht = setHeight(root);

        return root;
    }

    public static Node leftRotation(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        root.ht = setHeight(root);
        temp.ht = setHeight(temp);
        return temp;
    }

    public static Node rightRotation(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        root.ht = setHeight(root);
        temp.ht = setHeight(temp);
        return temp;
    }

    private static int setHeight(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static int height(Node root) {
        if (root == null) return -1;
        return root.ht;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int val = scan.nextInt();
            root = insert(root, val);
        }
        scan.close();
    }
}
