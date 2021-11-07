package HeadForOffer_II.Q041_Q050;

public class Q049_X {
    public static void main(String[] args) {

    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumNumbers(TreeNode root) {

        return dfs(root,0);
    }

    private int dfs(TreeNode root , int path){
        if (root == null){
            return 0;
        }

        path = path* 10 + root.val;

        if (root.right == null && root.left == null){
            return path;
        }

        return dfs(root.left,path) + dfs(root.right,path);


    }
}
