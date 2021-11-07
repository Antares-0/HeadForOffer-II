package HeadForOffer_II.Q061_Q070;

import java.util.*;

public class Q061 {

        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> heap = new PriorityQueue<>((o1, o2) -> (nums1[o1[0]] + nums2[o1[1]]) - nums2[o2[1]] - nums1[o2[0]]);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums2.length > 0) {
            for (int i = 0; i < k && i < nums1.length; i++) {
                heap.offer(new int[]{i, 0});
            }
        }

        while (k-- > 0 && !heap.isEmpty()){
            int [] ids = heap.poll();
            ans.add(Arrays.asList(nums1[ids[0]],nums2[ids[1]]));
            if (ids[1] < nums2.length - 1) {
                heap.offer(new int[]{ids[0], ids[1] + 1});
            }
        }
        return ans;
    }

}
