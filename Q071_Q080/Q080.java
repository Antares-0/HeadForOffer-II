package HeadForOffer_II.Q071_Q080;

import java.util.ArrayList;
import java.util.List;

public class Q080 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(n,k,1,ans,new ArrayList<>());
        return ans;
    }

    private void dfs(int n, int k, int count_of_n, List<List<Integer>> ans, List<Integer> list) {
        if (list.size() == k){
            ans.add(new ArrayList<>(list));
        } else if (count_of_n <= n){
            dfs(n,k,count_of_n+1,ans,list);
            list.add(count_of_n);
            dfs(n,k,count_of_n+1,ans,list);
            list.remove(list.size() -1);
        }
    }


}
