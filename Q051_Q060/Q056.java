package HeadForOffer_II.Q051_Q060;

import java.util.Stack;

public class Q056 {
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

    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack_start = new Stack<>();
        Stack<TreeNode> stack_end = new Stack<>();
        BSTIterator start = new BSTIterator(root);
        BSTIterator2 end = new BSTIterator2(root);
        int start_ = start.next();
        int end_ = end.next();
        while (start_ < end_){
            if (start_ + end_ < k){
                start_ = start.next();
            } else if (start_ + end_ == k){
                return true;
            } else {
                end_ = end.next();
            }
        }
        return false;
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

    class BSTIterator2 {
        Stack<TreeNode> stack;
        TreeNode cur;
        public BSTIterator2(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }

        public int next() {
            while (cur!= null){
                stack.push(cur);
                cur = cur.right;
            }
            TreeNode log = stack.pop();
            int ans = log.val;
            cur = log.left;
            return ans;
        }

        public boolean hasNext() {
            return cur!= null || !stack.isEmpty();
        }
    }

}
