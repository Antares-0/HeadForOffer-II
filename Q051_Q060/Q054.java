package HeadForOffer_II.Q051_Q060;

import java.util.Stack;

public class Q054 {
    public static void main(String[] args) {

    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        dfs(root,stack);
        int sum = 0;
        while (!stack.isEmpty()){
            TreeNode log = stack.pop();
            sum += log.val;
            log.val = sum;
        }
        return root;
    }

    private void dfs(TreeNode root, Stack<TreeNode> stack){
        if (root != null){
            dfs(root.left,stack);
            stack.push(root);
            dfs(root.right,stack);
        }
    }



}
