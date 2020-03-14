package bubble.palindrome;
import java.util.*;

/**
 * PalindromePartition
 */
public class PalindromePartition {
    static class DP {
        public List<ArrayList<String>> solve(String s) {
            if (s == null || s.length() == 0) {
                return new ArrayList<ArrayList<String>>();
            }
            int length = s.length();
            boolean[][] table = new boolean[length][length];
            for (int l = 0; l < length; l++) {
                for (int i = 0; i < length-1; i++) {
                    int j = i+l-1;
                    if (s.charAt(i) == s.length()) {
                        if(l == 1 || l == 2) {
                            table[i][j] = true;
                        } else {
                            table[i][j] = table[i+1][j-1];
                        }
                    } 
                }
            }
            return helper(s, 0, table);
        }

        private List<ArrayList<String>> helper(String s, int index, boolean[][] isPals){
            List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
            if (index == s.length()) {
                result.add(new ArrayList<String>());
                return result;
            }

            for (int i = index; i < s.length(); i++) {
                if(isPals[index][i]) {
                    for(ArrayList<String> temp: helper(s, i+1, isPals)) {
                        temp.add(0, s.substring(index, i+1));
                        result.add(temp);
                    }
                }
                
            }
            return result;
        }
    }
}