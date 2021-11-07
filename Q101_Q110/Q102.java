package HeadForOffer_II.Q101_Q110;

public class Q102 {
    public static void main(String[] args) {

    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1 || sum < Math.abs(target)){
            return 0;
        }
        int new_target = (sum + target) / 2;
        // 问题已经转化为求nums中可能出现和为new_target的次数
        int dp[] = new int[new_target + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = new_target; j >= 0; j--) {
                if (j >= nums[i-1]){
                    dp[j] += dp[j-nums[i-1]];
                }
            }
        }
        return dp[new_target];
    }
}
