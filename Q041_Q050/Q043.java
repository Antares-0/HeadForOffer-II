package HeadForOffer_II.Q041_Q050;

import java.util.LinkedList;
import java.util.Queue;

public class Q043 {
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

    class CBTInserter {
        TreeNode root;
        Queue<TreeNode> queue = new LinkedList<>();
        public CBTInserter(TreeNode root) {
            this.root = root;
            queue.offer(root);
            while (queue.peek().left != null && queue.peek().right != null){
                TreeNode log = queue.poll();
                queue.offer(log.left);
                queue.offer(log.right);
            }
        }

        public int insert(int val) {
            int ans = queue.peek().val;
            TreeNode node = new TreeNode(val);
            if (queue.peek().left == null){
                queue.peek().left = node;
            } else if (queue.peek().right == null){
                TreeNode log = queue.poll();
                log.right = node;
                // 这个地方这么写很巧妙
                queue.offer(log.left);
                queue.offer(log.right);
            }
            return ans;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
