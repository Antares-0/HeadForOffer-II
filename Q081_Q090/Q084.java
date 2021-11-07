package HeadForOffer_II.Q081_Q090;

import java.util.*;

public class Q084 {
    public static void main(String[] args) {

    }


/*    // 结果剪枝
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        dfs(nums,0,new ArrayList<>(),ans,new boolean[nums.length]);
        List<List<Integer>> result = new ArrayList<>(ans);
        return result;
    }

    private void dfs(int nums[], int path, List<Integer> list, Set<List<Integer>> ans, boolean [] ready){
        if (path == nums.length){
            ans.add(new ArrayList<>(list));
        } else {
            for (int i = 0;i<nums.length;i++){
                if (!ready[i]){
                    list.add(nums[i]);
                    ready[i] = true;
                    dfs(nums,path+ 1,list,ans,ready);
                    list.remove(list.size() - 1);
                    ready[i] = false;
                }
            }
        }
    }*/


    // 流程中剪枝
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ans, new boolean[nums.length]);
        return ans;
    }

    private void dfs(int[] nums, int path, List<Integer> list, List<List<Integer>> ans, boolean[] used) {
        if (path == nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i >= 1 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                used[i] = true;
                dfs(nums, path + 1, list, ans, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
