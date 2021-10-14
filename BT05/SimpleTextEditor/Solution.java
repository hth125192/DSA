import java.util.Stack;
import java.util.Scanner;

public class Solution {
    public static class SimpleTextEditor {
        private Stack<String> stack = new Stack<>();
        private String S = "";

        public SimpleTextEditor() {
            stack.push(S);
        }

        public void append(String W) {
            S += W;
            stack.push(S);
        }

        public void delete(int k) {
            S = S.substring(0, S.length() - k);
            stack.push(S);
        }

        public void print(int k) {
            System.out.println(S.charAt(k - 1));
        }

        public void undo() {
            stack.pop();
            S = stack.peek();
        }

    }

    public static void main(String[] args) {
        SimpleTextEditor s = new SimpleTextEditor();
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++)
            switch (sc.nextInt()) {
                case 1:
                    s.append(sc.next());
                    break;
                case 2:
                    s.delete(sc.nextInt());
                    break;
                case 3:
                    s.print(sc.nextInt());
                    break;
                case 4:
                    s.undo();
                    break;
                default:
                    break;
            }
    }

}
