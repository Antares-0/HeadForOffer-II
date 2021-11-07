package HeadForOffer_II.Q041_Q050;

import java.util.HashMap;
import java.util.Map;

public class Q050_X {
    public static void main(String[] args) {

    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return dfs(root,map,targetSum,0);

    }

    private int dfs(TreeNode root, Map<Integer,Integer> map, int sum,int path){
        if (root == null){
            return 0;
        }
        path += root.val;
        // 注意，path-sum是因为当前的值比如说是11，targetSum是8，那么相当于其实要找在之前的和为-3的节点数目
        // 才能11-3 = 8，实际上是找前面的节点为3的节点的数目，因为是求和再做差减下去
        int count = map.getOrDefault(path - sum,0);
        map.put(path,map.getOrDefault(path,0) + 1);
        int right = dfs(root.right,map,sum,path);
        int left = dfs(root.left,map,sum,path);
        map.put(path,map.get(path)-1);
        return count + right + left;

    }





}
