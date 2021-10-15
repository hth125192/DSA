import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        if (s.length() % 2 == 1) return "NO";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') stack.push(s.charAt(i));
            else {
                if (stack.isEmpty()) return "NO";
                char bracket = stack.pop();
                if ((s.charAt(i) == ')' && bracket != '(') || (s.charAt(i) == ']' && bracket != '[') || (s.charAt(i) == '}' && bracket != '{')) return "NO";
            }
        }
        if (stack.isEmpty()) return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[(())]()(){[{}]}[]{()}}()"));
    }

}
