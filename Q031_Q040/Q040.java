package HeadForOffer_II.Q031_Q040;

import java.util.Stack;

public class Q040 {
    public static void main(String[] args) {

    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int heights[] = new int[matrix[0].length];
        int ans = 0;
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '0') {
                    heights[i] = 0;
                } else {
                    heights[i]++;
                }
            }
            ans = Math.max(ans, heightToArea(heights));
        }
        return ans;
    }

    private int heightToArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                ans = Math.max(ans, height * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            ans = Math.max(ans, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return ans;
    }


}
