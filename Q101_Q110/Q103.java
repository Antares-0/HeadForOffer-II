package HeadForOffer_II.Q101_Q110;

import java.util.Arrays;

public class Q103 {
    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    if (dp[i - coins[j]] != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
                    }
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
