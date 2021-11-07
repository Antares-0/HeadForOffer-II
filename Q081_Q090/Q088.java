package HeadForOffer_II.Q081_Q090;

public class Q088 {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i-1], dp[i - 2] + cost[i-2]);
        }
        return dp[cost.length];
    }

}
