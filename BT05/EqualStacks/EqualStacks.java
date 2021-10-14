import java.util.List;
import java.util.Stack;

public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        int hight1 = 0;
        int hight2 = 0;
        int hight3 = 0;
        for (int i = h1.size() - 1; i >= 0; i--) {
            hight1 += h1.get(i);
            stack1.push(hight1);
        }
        for (int i = h2.size() - 1; i >= 0; i--) {
            hight2 += h2.get(i);
            stack2.push(hight2);
        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            hight3 += h3.get(i);
            stack3.push(hight3);
        }
        while (!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()) {
            hight1 = stack1.peek();
            hight2 = stack2.peek();
            hight3 = stack3.peek();
            if (hight1 == hight2 && hight2 == hight3) return hight1;
            if (hight1 >= hight2 && hight1 >= hight3) stack1.pop();
            else if (hight2 >= hight1 && hight2 >= hight3) stack2.pop();
            else stack3.pop();
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> h1 = List.of(3, 2, 1, 1, 1);
        List<Integer> h2 = List.of(4, 3, 2);
        List<Integer> h3 = List.of(1, 1, 4, 1);
        System.out.println(equalStacks(h1, h2, h3));
    }

}
