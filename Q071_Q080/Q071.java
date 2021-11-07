package HeadForOffer_II.Q071_Q080;

import java.util.Random;

public class Q071 {
    class Solution {

        int sum_ans [];
        int nums[];
        int sum;
        public Solution(int[] w) {
            nums = w;
            sum_ans = new int[w.length];
            sum = 0;
            for (int i = 0;i < w.length ;i++){
                sum += w[i];
                sum_ans[i] = sum;
            }
        }

        public int pickIndex() {
            Random i =  new Random();
            int target = i.nextInt(sum) + 1;
            int left = 0;
            int right = sum_ans.length;
            while(left < right){
                int mid = (left + right) / 2;
                if (sum_ans[mid] < target){
                    left = mid + 1;
                } else if (sum_ans[mid] == target){
                    return mid;
                } else {
                    right = mid;
                }
            }
            return right;
        }
    }
}
