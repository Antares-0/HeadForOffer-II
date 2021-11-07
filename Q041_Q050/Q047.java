package HeadForOffer_II.Q041_Q050;

public class Q047 {
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

    public TreeNode pruneTree(TreeNode root) {
        if (root.left != null){
            root.left = pruneTree(root.left);
        }

        if (root.right != null){
            root.right = pruneTree(root.right);
        }
        if (root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }




}
