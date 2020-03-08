package bubble.presum;

/**
 * MakePalindromeFromSubstring
 */
public class MakePalindromeFromSubstring {
    public boolean[] solve(String s, int[][] query) {
        boolean[] res = new boolean[query.length];
        int[][] presum = new int[s.length()+1][26];
        for(int i = 1; i<= s.length(); i++ ) {
            System.arraycopy(presum[i-1], 0, presum[i], 0, 26);
            presum[i][s.charAt(i-1)-'a']++;
        }
        for (int i = 0; i < query.length; i++) {
            int diff = 0;
            int left = query[i][0];
            int right = query[i][1];
            int k = query[i][2];
            for (int j = 0; j < 26; j++) {
                diff += (presum[right+1][j]-presum[left][j])%2; 
            }
            res[i] = (diff/2 <= k);
        }
        return res;
    }

    public static void main(String[] args) {
        MakePalindromeFromSubstring instance = new MakePalindromeFromSubstring();
        String s = "abcda";
        int[][] query = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        boolean[] res = instance.solve(s, query);
        for (boolean b : res) {
            System.out.println(b);
        }
    }
    
}