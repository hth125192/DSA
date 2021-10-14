import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static class QueueUsingTwoStacks {
        private Stack<Integer> stackNewestOnTop = new Stack<>();
        private Stack<Integer> stackOldestOnTop = new Stack<>();

        public void enqueue(Integer x) {
            stackNewestOnTop.push(x);
        }

        private void reverseStack() {
            if (stackOldestOnTop.isEmpty())
                while (!stackNewestOnTop.isEmpty()) stackOldestOnTop.push(stackNewestOnTop.pop());
        }

        public Integer dequeue() {
            reverseStack();
            return stackOldestOnTop.pop();
        }

        public Integer print() {
            reverseStack();
            return stackOldestOnTop.peek();
        }
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) queue.enqueue(sc.nextInt());
            else if (type == 2) queue.dequeue();
            else System.out.println(queue.print());
        }
    }

}
