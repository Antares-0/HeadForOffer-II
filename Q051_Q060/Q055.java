package HeadForOffer_II.Q051_Q060;

import java.util.Stack;

public class Q055 {
    public static void main(String[] args) {

    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class BSTIterator {
        Stack<TreeNode> stack;
        TreeNode cur;
        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }

        public int next() {
            while (cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode log = stack.pop();
            int ans = log.val;
            cur = log.right;
            return ans;
        }

        public boolean hasNext() {
            return cur!= null || !stack.isEmpty();
        }
    }
}
