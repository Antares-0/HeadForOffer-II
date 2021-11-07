package HeadForOffer_II.Q041_Q050;

import java.util.LinkedList;
import java.util.Queue;

public class Q045 {
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue_1 = new LinkedList<>();
        Queue<TreeNode> queue_2 = new LinkedList<>();
        queue_1.offer(root);
        int ans = queue_1.peek().val;
        while (queue_1.peek()!=null){
            while (queue_1.peek()!= null){
                TreeNode log = queue_1.poll();
                if (log.left != null){
                    queue_2.offer(log.left);
                }
                if (log.right != null){
                    queue_2.offer(log.right);
                }
            }
            ans = queue_2.peek()==null? ans:queue_2.peek().val;
            queue_1 = queue_2;
            queue_2 = new LinkedList<>();

        }
        return ans;
    }

}
