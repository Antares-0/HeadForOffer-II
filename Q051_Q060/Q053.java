package HeadForOffer_II.Q051_Q060;

public class Q053 {
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

    // O(h)复杂度
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode log = null;
        TreeNode cur = root;
        while (cur != null){
            if (cur.val <= p.val){
                cur = cur.right;
            } else {
                log = cur;
                cur = cur.left;
            }
        }
        return log;
    }

/*    // O(n)复杂度
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        List<TreeNode> list = new ArrayList<>();

        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode log = stack.pop();
            list.add(log);
            cur = log.right;
        }
        int i = list.indexOf(p);
        if (i == list.size() - 1){
            return null;
        }
        return list.get(i+1);
    }*/

}
