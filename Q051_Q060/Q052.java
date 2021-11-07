package HeadForOffer_II.Q051_Q060;

import java.util.ArrayList;
import java.util.List;

public class Q052 {
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

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode log = list.get(i);
            log.right = list.get(i + 1);
            log.left = null;
        }
        if (list.get(list.size() - 1) != null){
            list.get(list.size() - 1).right = null;
            list.get(list.size() - 1).left = null;
        }
        return list.get(0);
    }

    private List<TreeNode> dfs(TreeNode root, List<TreeNode> list) {
        if (root.left != null) {
            dfs(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            dfs(root.right, list);
        }
        return list;
    }



}
