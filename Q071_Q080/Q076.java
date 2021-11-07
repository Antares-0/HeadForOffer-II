package HeadForOffer_II.Q071_Q080;

import java.util.Random;

public class Q076 {
    public static void main(String[] args) {

    }
    /*    // 尝试使用最小堆实现，实现效果很好
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums){
            if (minHeap.size() < k){
                minHeap.offer(num);
            } else {
                if (num > minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }
        return minHeap.peek();
    }*/


    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int pos = nums.length - k;
        int i = partition(nums, start, end);
        while (i != pos) {
            if (i < pos) {
                start = i + 1;
            } else {
                end = i-1;
            }
            i = partition(nums,start,end);
        }
        return nums[i];
    }

    public int partition(int[] nums, int start, int end) {
        int k = new Random().nextInt(end - start + 1) + start;
        swap(nums, end, k);
        int p1 = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                p1++;
                swap(nums, i, p1);
            }
        }
        p1++;
        swap(nums, end, p1);
        return p1;
    }

    public void swap(int[] nums, int a, int b) {
        int log = nums[a];
        nums[a] = nums[b];
        nums[b] = log;
    }

}
