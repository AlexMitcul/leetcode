import java.util.HashMap;
import java.util.Stack;

public class NumberOfAtoms {

    public String countOfAtoms(String formula) {
        Stack<HashMap<String, Integer>> stack = new Stack<>();

        stack.push(new HashMap<>());

        int index = 0;
        while (index < formula.length()) {
            if (formula.charAt(index) == '(') {
                stack.push(new HashMap<>());
                index++;
            } else if (formula.charAt(index) == ')') {
                int i = ++index;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplier = 1;
                try {
                    multiplier = Integer.parseInt(formula.substring(index, i));
                } catch (Exception ignored) {}
                var map = stack.pop();
                for (var key : map.keySet()) {
                    int currCount = map.get(key) * multiplier;
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + currCount);
                }
                index = i;
            } else {
                int i = index + 1;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String element = formula.substring(index, i);
                index = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = 1;
                try {
                    count = Integer.parseInt(formula.substring(index, i));
                } catch (Exception ignored) {}
                var map = stack.peek();
                map.put(element, map.getOrDefault(element, 0) + count);
                index = i;
            }
        }

        StringBuilder result = new StringBuilder();
        var map = stack.pop();
        for (var element : map.keySet().stream().sorted().toList()) {
            int count = map.get(element);
            result.append(element);
            if (count > 1) result.append(count);
        }

        return result.toString();
    }

}
