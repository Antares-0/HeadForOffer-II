package HeadForOffer_II.Q011_Q020;

public class Q012 {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num:nums){
            sum += num;
        }
        boolean flag = true;
        int sum_of_left = 0;
        int sum_of_right = sum - nums[0];
        int ans = -1;
        if (sum_of_left == sum_of_right){
            return 0;
        }
        for (int i = 1 ;i<nums.length;i++){
            sum_of_right = sum_of_right - nums[i];
            sum_of_left = sum_of_left + nums[i - 1];
            if (flag && sum_of_left == sum_of_right) {
                ans = i;
                flag = false;
            }
        }
        return ans;
    }
}
