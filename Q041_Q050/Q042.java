package HeadForOffer_II.Q041_Q050;

import java.util.LinkedList;
import java.util.Queue;

public class Q042 {
    public static void main(String[] args) {

    }

    class RecentCounter {
        Queue<Integer> queue;
        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            if (queue.isEmpty()){
                queue.offer(t);
            } else {
                while (!queue.isEmpty() && queue.peek() < t - 3000){
                    queue.poll();
                }
                queue.offer(t);
            }
            return queue.size();
        }
    }
}
