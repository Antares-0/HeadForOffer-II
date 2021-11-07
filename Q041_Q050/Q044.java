package HeadForOffer_II.Q041_Q050;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q044 {
    public static void main(String[] args) {

    }
    public class TreeNode {
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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur = 1;
        int next = 0;
        while (queue.peek() != null){
            int max = Integer.MIN_VALUE;
            for (;cur>0;cur--){
                TreeNode log = queue.poll();
                if (log.left != null){
                    queue.offer(log.left);
                    next++;
                }
                if (log.right != null){
                    queue.offer(log.right);
                    next++;
                }
                max = Math.max(max,log.val);
            }
            ans.add(max);
            cur = next;
            next = 0;
        }
        return ans;
    }

}
