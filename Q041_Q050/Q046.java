package HeadForOffer_II.Q041_Q050;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q046 {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1_log = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int ans_log = 0;
            while (!queue.isEmpty()) {
                TreeNode log = queue.poll();
                if (log.left != null) {
                    queue1_log.offer(log.left);
                }
                if (log.right != null) {
                    queue1_log.offer(log.right);
                }
                ans_log = log.val;
            }
            ans.add(ans_log);
            queue = queue1_log;
            queue1_log = new LinkedList<>();
        }
        return ans;
    }
}
