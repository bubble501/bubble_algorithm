package bubble.stack;
import java.util.*;
/**
 * ReverseSasdfubstringInParentheses
 */
public class ReverseSubstringInParentheses {
    public String solve(String source) {
        char[] chs = source.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            if (ch=='(') {
                stack.push(i);
            } else if (ch == ')') {
                int left = stack.pop();
                int right = i;
                while (left < right) {
                    char temp = chs[left];
                    chs[left++] = chs[right];
                    chs[right--] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            if(chs[i] != '(' && chs[i] != ')') {
               sb.append(chs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseSubstringInParentheses instance = new ReverseSubstringInParentheses();
        System.out.println(instance.solve("(ed(et(oc))el)"));
    }
}