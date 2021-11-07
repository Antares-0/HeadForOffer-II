package HeadForOffer_II.Q001_Q010;

public class Q009_ {
    public static void main(String[] args) {
        Q009_ i = new Q009_();
        int nums [] = {10,5,2,6};
        System.out.println(i.numSubarrayProductLessThanK(nums,100));

    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int count = 0;
        int left = 0;
        for (int right=0;right<nums.length;right++){
            product *= nums[right];
            while(product>=k && right >=left){
                product /= nums[left++];
            }
            count += right>=left? right - left + 1:0;
        }
        return count;
    }
}
