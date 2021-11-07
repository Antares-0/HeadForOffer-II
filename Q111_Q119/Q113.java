package HeadForOffer_II.Q111_Q119;

import java.util.*;

public class Q113 {
    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int [] innumbers = new int[numCourses];
        for (int link[] : prerequisites){
            innumbers[link[0]]++;
            map.putIfAbsent(link[1],new ArrayList<>());
            map.get(link[1]).add(link[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0;i<numCourses;i++){
            if (innumbers[i] == 0){
                queue.offer(i);
            }
        }
        List<Integer> list_ans = new ArrayList<>();
        while (!queue.isEmpty()){
            int log = queue.poll();
            list_ans.add(log);
            List<Integer> list = map.get(log);
            if (list!= null){
                for (int i : list){
                    innumbers[i]--;
                    // 避免环出现的关键代码
                    if (innumbers[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return list_ans.size() == numCourses ? list_ans.stream().mapToInt(i ->i).toArray() : new int[0];
    }

}
