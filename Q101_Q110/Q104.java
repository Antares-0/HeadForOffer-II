package HeadForOffer_II.Q101_Q110;

public class Q104 {
    public static void main(String[] args) {

    }

    public int combinationSum4(int[] nums, int target) {
        // 完全背包问题，但是序列不同
        int dp[] = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i < target; i++) {
            for(int j = 0;j<nums.length;j++){
                if (i>=nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
