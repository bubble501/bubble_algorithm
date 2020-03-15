package bubble.dp;

/**
 * CoinChangeII
 */
public class CoinChangeII {

    public int solve(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins == null || coins.length < 1 || amount < 0) return 0;
        int[] dp = new int [amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        // int[] coins = {1, 3, 5, 7};
        int[] coins = {7, 5, 3, 1};
        CoinChangeII ins = new CoinChangeII();
        System.out.println(ins.solve(8, coins));
    }
}