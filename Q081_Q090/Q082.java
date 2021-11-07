package HeadForOffer_II.Q081_Q090;

import java.util.*;

public class Q082 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<>();
        dfs(candidates,target,0,0,set,new ArrayList<>());
        ArrayList<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    private void dfs(int[] candidates, int target, int candidates_index, int sum, Set<List<Integer>> set, List<Integer> list) {
        if (sum == target) {
            ArrayList<Integer> list_log = new ArrayList<>(list);
            Collections.sort(list_log);
            set.add(list_log);
        } else if (sum < target && candidates_index < candidates.length) {
            list.add(candidates[candidates_index]);
            sum += candidates[candidates_index];
            dfs(candidates, target, getNext(candidates,candidates_index), sum, set, list);
            sum -= list.remove(list.size() - 1);
            dfs(candidates, target, candidates_index + 1, sum, set, list);

        }
    }
    private int getNext(int nums[],int index){
        int log = nums[index];
        while (index< nums.length && log == nums[index]){
            index ++;
        }
        return index;
    }

}
