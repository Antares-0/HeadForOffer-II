package HeadForOffer_II.Q031_Q040;

import java.util.Stack;

public class Q037 {
    public static void main(String[] args) {

    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int as : asteroids){
            while (as < 0 && !stack.empty() && stack.peek()>0 && stack.peek() < -as){
                stack.pop();
            }

            if (!stack.empty() && stack.peek() == -as && as<0){
                stack.pop();
            } else if (stack.empty() || stack.peek() < 0 || as >0){
                stack.push(as);
            }
        }
        // 第一次了解这个mapToInt方法
        return stack.stream().mapToInt(i->i).toArray();
    }



}
