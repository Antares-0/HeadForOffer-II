package HeadForOffer_II.Q071_Q080;

import java.util.ArrayList;
import java.util.List;

public class Q079 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0,nums,new ArrayList<>(),ans);
        return ans;
    }

    private void dfs(int index, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            dfs(index + 1, nums, list, ans);

            list.add(nums[index]);
            dfs(index + 1, nums, list, ans);
            list.remove(list.size()-1);
        }
    }

}
