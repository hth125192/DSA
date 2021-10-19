public class TestStackQueue {
    public static void main(String[] args) {
        ResizingArrayStack<Integer> s = new ResizingArrayStack<>();
        s.push(17);
        int a = s.pop();
        System.out.print(a);
    }
}
