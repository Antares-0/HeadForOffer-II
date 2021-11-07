package HeadForOffer_II.Q071_Q080;

import java.util.Arrays;
import java.util.Stack;

public class Q074 {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        // 对区间排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        Stack<int []> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (stack.peek()[1] >= intervals[i][0]){
                int [] log = stack.pop();
                int [] ans = new int[2];
                ans[0] = log[0];
                ans[1] = Math.max(intervals[i][1],log[1]);
                stack.push(ans);
            } else {
                stack.push(intervals[i]);
            }
        }
        int [][] ans = new int[stack.size()][2];
        int i = 0;
        for (int [] list : stack){
            ans[i] = list;
            i++;
        }
        return ans;
    }
}
