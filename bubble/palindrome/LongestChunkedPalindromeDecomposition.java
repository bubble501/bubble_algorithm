package bubble.palindrome;

/**
 * LongestChunkedPalindromeDecomposition
 */
public class LongestChunkedPalindromeDecomposition {
    static class S1 {
        public int solve(String text) {
            if (text==null || text.length()==0) return 0;
            int res = 0;
            String left = "";
            String  right = "";
            for (int i = 0; i < text.length(); i++) {
                int j = text.length() -1 - i;
                left = left + text.charAt(i);
                right = right + text.charAt(j); 
                if(left.equals(right)) {
                    res +=1;
                    left = "";
                    right = "";
                }
            }
            return res;
        }
    }
}