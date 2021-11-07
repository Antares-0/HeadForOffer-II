package HeadForOffer_II.Q031_Q040;

import java.util.Stack;

public class Q039 {
    public static void main(String[] args) {

    }

    // 单调栈解法

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        // stack.push(-1);
        // 入栈处理过程
        int ans = 0;
        for (int i = 0;i<heights.length;i++){
            if (stack.empty()){
                stack.push(i);
            } else if (heights[i] <= heights[stack.peek()]){
                // 计算以height为顶的矩形大小
                while (!stack.empty() && heights[i] <= heights[stack.peek()]) {
                    int log = stack.pop();
                    int height = heights[log];
                    if (stack.empty()) {
                        ans = Math.max(height * (i), ans);
                    } else {
                        ans = Math.max(height * (i - stack.peek() - 1), ans);
                    }
                }
                stack.push(i);
            } else if (heights[i] > heights[stack.peek()]){
                stack.push(i);
            } /*else if (heights[i] == heights[stack.peek()]){
                // 处理相等的时候
                stack.pop();
                stack.push(i);
            }*/
        }

        while (!stack.empty()){
            int log = stack.pop();
            int end = heights.length;
            if (!stack.empty()){
                ans = Math.max(ans,heights[log] * (end - stack.peek() -1));
            } else {
                ans = Math.max(ans,heights[log] * heights.length);
            }
        }
        return ans;
    }

}
