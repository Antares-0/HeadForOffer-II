package HeadForOffer_II.Q081_Q090;

public class Q090 {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length-1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2;i<nums.length - 1; i++){
            dp[i] = Math.max(dp[i-2] + nums[i-1],dp[i-1]);
        }
        int log_0_n_1 = dp[nums.length - 1];

        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2;i<nums.length - 1; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return Math.max(log_0_n_1,dp[nums.length - 1]);
    }
}
