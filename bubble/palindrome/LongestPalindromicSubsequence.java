package bubble.palindrome;

/**
 * LongestPalindromicSubsequence
 */
public class LongestPalindromicSubsequence {



    public int solve(String s) {
        int size = s.length();
        int[][] dp = new int[size][size];
        for (int i = size-1; i >= 0 ; i--) {
            dp[i][i] = 1;

        }
        return 0;
    }
}