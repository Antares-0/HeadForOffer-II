package HeadForOffer_II.Q051_Q060;

import java.util.*;

public class Q060 {
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        // pq中可以使用int[] 是比较精彩的

        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Set<Integer> ints = map.keySet();
        for (int num : ints){
            int a [] = new int[2];
            a[0] = num;
            a[1] = map.get(num);
            if (pq.size() < k){
                pq.offer(a);
            } else if (pq.peek()[1] < a[1]){
                pq.poll();
                pq.offer(a);
            }
        }

        int ans [] = new int[k];
        int i = 0 ;
        for (int[] b : pq){
            ans[i] = b[0];
            i++;
        }
        return ans;


    }

}
