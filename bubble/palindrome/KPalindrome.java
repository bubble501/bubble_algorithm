package bubble.palindrome;

/**
 * KPalindrome
 *  removing at most k charaters.
 */
public class KPalindrome {
    static class Recursive {
        public boolean solve(String s, int k) {
            String rev = new StringBuilder(s).reverse().toString();
            if (distance(s, s.length(), rev, rev.length()) <= 2*k) {
                return true;
            } else {
                return false;
            }
        }

        private int distance(String X, int m, String Y, int n) {
            if (m == 0 || n == 0) {
                return n + m;
            }

            if (X.charAt(m-1)==Y.charAt(n-1)) {
                return distance(X, m-1, Y, n-1);
            }

            int x = distance(X, m-1, Y, n);
            int y = distance(X, m, Y, n-1);
            return 1 + Math.min(x, y);
        }
    }

    static class DP1 {
        public boolean solve(String s, int k ) {
            String rev = new StringBuilder(s).reverse().toString();
            int n = s.length();
            int[][] d = new int[n+1][n+1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i==0 || j==0) {
                        d[i][j] = i + j;
                    }
                    else if (s.charAt(i-1) == rev.charAt(j-1)) {
                        d[i][j] = d[i-1][j-1];
                    }
                    else {
                        d[i][j] = 1 + Math.min(d[i-1][j], d[i][j-1]);
                    }
                }
            }
            return (d[n][n] <= 2*k);
        }
    }

    static class LPS {

    }
}