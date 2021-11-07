package HeadForOffer_II.Q031_Q040;

import java.util.Stack;

public class Q036 {
    public static void main(String[] args) {
        // 栈的实战演练
//        Stack<Integer> s = new Stack<>();
//        s.push(8);
//        s.push(7);
//        s.push(6);
//        System.out.println(s.pop());
//        System.out.println(s.peek());
//        System.out.println(s.pop());
    }
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0){
            return 0;
        }
        Stack<Integer> num = new Stack<>();
        for (int i = 0;i< tokens.length;i++){
            String s = tokens[i];
            if (Character.isDigit(s.charAt(0)) || s.length() >=2 ){
                num.push(Integer.parseInt(s));
            } else {
                int pop_a = num.pop();
                int pop_b = num.pop();
                int ans = 0;
                switch (s.charAt(0)){
                    case '-':
                        ans = pop_b - pop_a;
                        break;
                    case '*':
                        ans = pop_b * pop_a;
                        break;
                    case '+':
                        ans = pop_b + pop_a;
                        break;
                    case '/':
                        ans = pop_b / pop_a;
                        break;
                    default:
                        break;
                }
                num.push(ans);
            }
        }
        return num.pop();
    }



}
