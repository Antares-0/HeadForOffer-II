package HeadForOffer_II.Q091_Q100;

public class Q099 {
    public static void main(String[] args) {

    }
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length + 1][grid[0].length + 1];
        // 初始化
        for (int i = 1;i<= grid.length;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 1;i<=grid[0].length;i++){
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i==0 && j==0){
                    dp[1][1] = grid[0][0];
                } else {
                    dp[i + 1][j+1] = Math.min(dp[i][j+1],dp[i+1][j]) + grid[i][j];
                }
            }
        }
        return dp[grid.length][grid[0].length];
    }


}
