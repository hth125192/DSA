import java.util.Scanner;

public class LCABST {
    private static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node lca(Node root, int v1, int v2) {
        if (root == null) return null;
        if (root.data == v1 || root.data == v2) return root;
        Node left = lca(root.left, v1, v2);
        Node right = lca(root.right, v1, v2);
        if (left != null) {
            if (right != null) return root;
            return left;
        }
        return right;
    }

    public static Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        Node cur;
        if (data <= root.data) {
            cur = insert(root.left, data);
            root.left = cur;
        } else {
            cur = insert(root.right, data);
            root.right = cur;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }
}
