package HeadForOffer_II.Q061_Q070;

public class Q068 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            if (nums[right] < target){
                return right + 1;
            }

            if (nums[left] >= target){
                return left;
            }
            int mid = (right + left) / 2;
            if (nums[mid] == target){
                break;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (right + left) / 2;
    }

}
