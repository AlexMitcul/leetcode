import java.util.Stack;

/**
 * 1717. Maximum Score From Removing Substrings
 * <a href="https://leetcode.com/problems/maximum-score-from-removing-substrings/">Link</a>
 */
public class MaximumScoreFromRemovingSubstrings {

    private int solve(String s, int x, int y, char xC, char yC) {
        Stack<Character> stack = new Stack<>();
        int res = 0;

        for (var ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == xC && ch == yC) {
                stack.pop();
                res += x;
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        for (var ch : sb.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == yC && ch == xC) {
                stack.pop();
                res += y;
            } else {
                stack.push(ch);
            }
        }

        return res;
    }

    public int maximumGain(String s, int x, int y) {
        return (x > y) ? solve(s, x, y, 'a', 'b') : solve(s, y, x, 'b', 'a');
    }
}