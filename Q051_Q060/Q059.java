package HeadForOffer_II.Q051_Q060;

import java.util.PriorityQueue;

public class Q059 {
    public static void main(String[] args) {

    }

    class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                if (pq.size() < k) {
                    pq.offer(nums[i]);
                } else {
                    if (pq.peek() < nums[i]) {
                        pq.poll();
                        pq.offer(nums[i]);
                    }
                }
            }
        }

        public int add(int val) {
            if (pq.size() < k) {
                pq.offer(val);
            } else {
                if (pq.peek() < val) {
                    pq.poll();
                    pq.offer(val);
                }
            }
            return pq.peek();
        }
    }

}
