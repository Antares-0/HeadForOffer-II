package HeadForOffer_II.Q081_Q090;

import java.util.ArrayList;
import java.util.List;

public class Q081 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates,0,target,0,new ArrayList<>(),ans);
        return ans;
    }

    private void dfs(int[] candidates, int index, int target, int sum, List<Integer> list, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
        } else if (sum < target && index < candidates.length) {
            list.add(candidates[index]);
            sum += candidates[index];
            dfs(candidates, index, target, sum, list, ans);
            sum -= list.remove(list.size() - 1);
            dfs(candidates, index + 1, target, sum, list, ans);
        }
    }

}
