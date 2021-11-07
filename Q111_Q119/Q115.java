package HeadForOffer_II.Q111_Q119;

import java.util.*;

public class Q115 {
    public static void main(String[] args) {


    }
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> inDegree = new HashMap<>();

        for (List<Integer> list : seqs){
            // 初始化
            for (int num : list){
                if(num > org.length || num < 1){
                    return false;
                }
                graph.putIfAbsent(num,new HashSet<>());
                inDegree.putIfAbsent(num,0);
            }
            for (int i= 0;i<list.size() - 1;i++){
                if (!graph.get(list.get(i)).contains(list.get(i + 1))){
                    graph.get(list.get(i)).add(list.get(i+1));
                    inDegree.put(list.get(i+1),inDegree.get(list.get(i+1)) + 1);
                }
            }

        }
        Queue<Integer> queue = new LinkedList<>();
        for (int num : inDegree.keySet()){
            if (inDegree.get(num) == 0){
                queue.add(num);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (queue.size() == 1){
            int log = queue.poll();
            list.add(log);
            for (int num : graph.get(log)){
                inDegree.put(num,inDegree.get(num) - 1);
                if (inDegree.get(num) == 0){
                    queue.add(num);
                }
            }
        }

        int re [] = list.stream().mapToInt(i->i).toArray();
        return Arrays.equals(re,org);
    }


}
