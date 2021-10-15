import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

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

    public static void main(String[] args) throws IOException {
        SimpleTextEditor s = new SimpleTextEditor();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < Q; i++) {
            String[] type = bufferedReader.readLine().split(" ");
            switch (type[0]) {
                case "1":
                    s.append(type[1]);
                    break;
                case "2":
                    s.delete(Integer.parseInt(type[1]));
                    break;
                case "3":
                    s.print(Integer.parseInt(type[1]));
                    break;
                case "4":
                    s.undo();
                    break;
                default:
                    break;
            }
        }
    }

}
