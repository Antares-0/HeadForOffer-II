package HeadForOffer_II.Q001_Q010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q007 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int [] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            int start = i+1;
            int end = nums.length - 1;
            int flag = nums[i];
            while(start < end){
                if (nums[start] + nums[end] == - nums[i]){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[start]);
                    list.add(nums[end]);
                    list.add(nums[i]);
                    ans.add(list);
                    end--;
                    while (end+1<nums.length && end>=0 && nums[end] == nums[end+1]){
                        end--;
                    }
                } else if (nums[start] + nums[end] > - nums[i]){
                    end--;
                } else if (nums[start] + nums[end] < - nums[i]){
                    start++;
                }
            }
            while(i<nums.length-2 && flag == nums[i+1]){
                i++;
            }
        }
        return ans;
    }

}
