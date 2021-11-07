package HeadForOffer_II.Q041_Q050;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q041 {
    public static void main(String[] args) {

    }

    class MovingAverage {
        Queue<Integer> queue;
        int count = 0;
        int sum = 0;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            queue = new ArrayDeque<>(size);
        }

        public double next(int val) {
            if (count < queue.size()){
                queue.offer(val);
                count ++;
                sum = sum + val;
            } else {
                sum = sum - queue.poll() + val;
                queue.offer(val);
            }
            return (double) sum / queue.size();
        }
    }

}
