package HeadForOffer_II.Q051_Q060;

public class Q051 {
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

    public int maxPathSum(TreeNode root) {
        int [] n = {Integer.MIN_VALUE};
        dfs(root,n);
        return n[0];
    }

    public int dfs(TreeNode root, int[] nums) {
        if (root == null) {
            return 0;
        }
        int[] left = {Integer.MIN_VALUE};
        int left_ = Math.max(0 ,dfs(root.left, left));
        int[] right = {Integer.MIN_VALUE};
        int right_ = Math.max(0,dfs(root.right, right));
        // 首先更新nums[0]，它代表了全局最大值，这里是检测仅左节点和右节点的最大值
        nums[0] = Math.max(left[0], right[0]);
        nums[0] = Math.max(nums[0],root.val + left_ +right_);
        // 需要返回的是，告诉父节点，这个节点下的最大值是多少
        return root.val + Math.max(left_ , right_);

    }
}
