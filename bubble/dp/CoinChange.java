package bubble.dp;

/**
 * CoinChange
 */
public class CoinChange {

    int solve(int[] s, int n) {
        int[] t = new int[n+1];

        for (int i = 1; i <= n; i++) {
            t[i] = Integer.MAX_VALUE;
            int res = Integer.MAX_VALUE;
            for (int c = 0; c < s.length; c++) {
                if (i - s[c] >= 0) {
                    res = t[i-s[c]];
                }
                if (res != Integer.MAX_VALUE) {
                    t[i] = Math.min(t[i], res+1);
                }
            }
        }
        return t[n];
    }
}