package HeadForOffer_II.Q081_Q090;

import java.util.ArrayList;
import java.util.List;

public class Q083 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean [] ready = new boolean[nums.length];
        dfs(nums,0,new ArrayList<>(),ready,ans);
        return ans;
    }

    private void dfs(int nums[], int path, List<Integer> list, boolean[] ready, List<List<Integer>> ans) {
        if (path == nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!ready[i]) {
                    list.add(nums[i]);
                    ready[i] = true;
                    dfs(nums, path + 1, list, ready, ans);
                    list.remove(list.size() - 1);
                    ready[i] = false;
                }
            }
        }
    }

}
