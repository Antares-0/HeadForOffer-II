package HeadForOffer_II.Q101_Q110;

public class Q101 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean dp[][] = new boolean[nums.length + 1][target + 1];
        for (int i = 0;i<= nums.length;i++){
            dp[i][0] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < target; j++) {
                // 不选
                dp[i + 1][j + 1] = dp[i][j + 1];
                // 选
                if (!dp[i + 1][j + 1] && j + 1 >= nums[i]) {
                    dp[i + 1][j + 1] = dp[i][j - nums[i] + 1];
                }
            }
        }
        return dp[nums.length][target];
    }
}
