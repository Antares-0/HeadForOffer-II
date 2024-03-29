package HeadForOffer_II.Q091_Q100;

public class Q096 {
    public static void main(String[] args) {

    }


    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            dp[i+1][0] = dp[i][0] && s1.charAt(i) == s3.charAt(i);
        }
        for (int j = 0; j < s2.length(); j++) {
            dp[0][j+1] = dp[0][j] && s2.charAt(j) == s3.charAt(j);
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                dp[i + 1][j + 1] = (dp[i][j+1] && s3.charAt(i + j + 1)==s1.charAt(i)) ||(dp[i + 1][j] && s3.charAt(i + j + 1)==s2.charAt(j));
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
