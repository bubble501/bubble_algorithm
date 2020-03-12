package bubble.palindrome;
import java.util.*;

/**
 * PalindromePermutation
 */
public class PalindromePermutation {

    public boolean solve(String s) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (set.contains(index)) {
                set.remove(index);
            } else {
                set.add(index);
            }
        }
        return set.size() < 2;
    }
}