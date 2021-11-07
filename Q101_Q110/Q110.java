package HeadForOffer_II.Q101_Q110;

import java.util.ArrayList;
import java.util.List;

public class Q110 {
    public static void main(String[] args) {
        Q110 i = new Q110();
        int [][] j = {{1,2},{3},{3},{}};
        System.out.println(i.allPathsSourceTarget(j));
    }

    // 是一个深度优先搜索 + 回溯
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(graph,answer,new ArrayList<>(),0);
        return answer;
    }

    private void dfs(int [][] graph, List<List<Integer>> list, List<Integer> path, int src){
        if (src == graph.length - 1){
            path.add(src);
            list.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        for (int dir : graph[src]){
            path.add(src);
            dfs(graph,list,path,dir);
            path.remove(path.size() - 1);
        }
    }


}
