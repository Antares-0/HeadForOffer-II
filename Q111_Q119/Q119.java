package HeadForOffer_II.Q111_Q119;

import java.util.HashMap;

public class Q119 {
    public static void main(String[] args) {

    }


    // 并查集写法
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> graph = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            graph.put(num, num);
            count.put(num, 1);
        }
        for (int num : nums) {
            if (graph.keySet().contains(num + 1)) {
                Union(graph, count, num, num + 1);
            }
            if (graph.keySet().contains(num - 1)) {
                Union(graph, count, num, num - 1);
            }
        }
        int answer = 0;
        for (int num : count.keySet()){
            answer = Math.max(count.get(num),answer);
        }
        return answer;

    }

    private boolean Union(HashMap<Integer, Integer> graph, HashMap<Integer, Integer> count, int num, int numPlusOne) {
        int a = findFather(graph,num);
        int b = findFather(graph,numPlusOne);
        if (a != b) {
            count.put(b,count.get(a) + count.get(b));
            graph.put(a, b);
            return true;
        }
        return false;
    }

    private int findFather(HashMap<Integer, Integer> graph, int num) {
        if (graph.get(num) != num) {
            graph.put(num, findFather(graph, graph.get(num)));
        }
        return graph.get(num);
    }


/*    // 深度优先搜索
    public int longestConsecutive(int[] nums) {

    }*/


    /*
    // 广度优先搜索版本
    public int longestConsecutive(int[] nums) {
        Map<Integer,Boolean> visited = new HashMap<>();
        for (int num : nums){
            visited.put(num,false);
        }
        int [] number = new int[1];
        for (int num : nums){
            if (!visited.get(num)){
                bfs(visited,num,number);
            }
        }
        return number[0];
    }

    private void bfs(Map<Integer,Boolean> visited, int num ,int [] answer){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        int count = 0;
        while (!queue.isEmpty()){
            int log = queue.poll();
            visited.put(log,true);
            count++;
            if (visited.keySet().contains(log + 1)){
                queue.offer(log+1);
            }
        }
        answer[0] = Math.max(count,answer[0]);
    }*/

}
