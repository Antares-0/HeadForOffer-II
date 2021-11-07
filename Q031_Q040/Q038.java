package HeadForOffer_II.Q031_Q040;

import java.util.Stack;

public class Q038 {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int ans [] = new int[temperatures.length];
        for (int i = 0;i<temperatures.length;i++){
            if (stack.empty()){
                stack.push(i);
            } else if (temperatures[stack.peek()] >= temperatures[i]){
                stack.push(i);
            } else if (!stack.empty() && temperatures[stack.peek()] < temperatures[i]){
                while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]){
                    int log = stack.pop();
                    ans[log] = i - log;
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
