package bubble.dp;

/**
 * LongestCommonSubsequence
 */
public class LongestCommonSubsequence {

    int solve(String a, String b) {
        int m = a.length();
        int n = b.length();
        int res[][] = new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (a.charAt(i)==b.charAt(j)) {
                    res[i][j] = res[i-1][j-1] + 1;
                } else {
                    res[i][j] = Math.max(res[i][j-1], res[i-1][j]);
                }
            }
        }
        return res[m][n];
    }
}