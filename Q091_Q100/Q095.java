package HeadForOffer_II.Q091_Q100;

public class Q095 {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length() + 1][text2.length() + 1];
        char [] chars_text1 = text1.toCharArray();
        char [] chars_text2 = text2.toCharArray();
        for (int i = 0;i<text1.length();i++){
            for (int j =0;j<text2.length();j++){
                if (chars_text1[i] != chars_text2[j]){
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                } else {
                    dp[i+1][j+1] = dp[i][j] + 1;
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
