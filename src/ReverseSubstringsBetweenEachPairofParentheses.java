import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {

    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();

        for (var ch : s.toCharArray()) {
            if (ch == ')') {
                sb.append(stack.pop().reverse()).reverse();
            } else if (ch == '(') {
                stack.push(sb);
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
