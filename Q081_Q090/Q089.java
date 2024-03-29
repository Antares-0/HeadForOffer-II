package HeadForOffer_II.Q081_Q090;

public class Q089 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int dp[] = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2;i < nums.length + 1;i++){
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }
        return dp[nums.length];
    }
}
