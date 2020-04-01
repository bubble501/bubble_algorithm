package bubble.slidewindows;
import java.util.*;

/**
 * LongestSubstringWithoutRepeatingCharacters
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int solve(String s) {
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> dict = new HashMap<>();
        int res = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (dict.containsKey(c)&& start <= dict.get(c)) {
                start = dict.get(c) + 1;
            } else {
                res = Math.max(res, end-start+1);
            }
            dict.put(s.charAt(end), end);
        }
        return res;
    }
}