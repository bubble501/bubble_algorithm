package bubble.stack;
import java.util.*;
/**
 * ValidParentheses
 */
public class ValidParentheses {

    public boolean isValid(String symbols) {
        Map<Character, Character> matechs = new HashMap<>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < symbols.length(); i++) {
            char b = symbols.charAt(i);
            if (b == '(' || b== '{' || b== '[') {
                stack.push(b);
            } else {
                if (stack.isEmpty() || b != matechs.getOrDefault(stack.peek(), null)){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses ins = new ValidParentheses();
        String symbols = "}}}}";
        System.out.println(ins.isValid(symbols));
    }
}