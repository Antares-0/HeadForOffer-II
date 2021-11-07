package HeadForOffer_II.Q041_Q050;

public class Q048_X {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null){
                return "#";
            }
            String left = serialize(root.left);
            String right = serialize(root.right);
            return root.val + "," + left + "," + right;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(",");
            int i[] = {0};
            return dfs(split,i);
        }

        private TreeNode dfs(String[] strs,int i[]){
            String m = strs[i[0]];
            i[0]++;

            if (m.equals("#")){
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(m));
            node.left = dfs(strs,i);
            node.right = dfs(strs,i);
            return node;
        }

    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
