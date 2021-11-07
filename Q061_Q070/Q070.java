package HeadForOffer_II.Q061_Q070;

public class Q070 {
    public static void main(String[] args) {
        int nums [] = {1,1,2,2,3};
        Q070 i = new Q070();
        System.out.println(i.singleNonDuplicate(nums));
    }

/*    // 粗糙版二分查找
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (mid > 1 && mid < nums.length - 2 && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                return nums[mid];
            }
            if ((mid - left) % 2 == 1){
                if (nums[mid] == nums[mid - 1]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid + 1]){
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left];
    }*/

    public int singleNonDuplicate(int[] nums) {
        // 只检查前面的n组，如果前面n组都相同，就直接返回最后一个元素
        // 反之如果前面n组出现了差异，就找到最先出现差异的地方
        int start = 0;
        int end = nums.length / 2;
        while (start <= end){
            int mid = (start + end) / 2;
            int i = mid * 2;
            if (i < nums.length- 1 && nums[i + 1] != nums[i]){
                if (mid == 0 || nums[i - 1] == nums[i-2]){
                    return nums[i];
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nums[nums.length - 1];
    }


}
