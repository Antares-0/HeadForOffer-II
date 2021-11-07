package HeadForOffer_II.Q091_Q100;

public class Q098 {
    public static void main(String[] args) {

    }

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 && j== 0){
                    dp[1][1] = 1;
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[m][n];
    }
}
