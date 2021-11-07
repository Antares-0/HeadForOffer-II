package HeadForOffer_II.Q091_Q100;

public class Q094 {
    public static void main(String[] args) {

    }

    public int minCut(String s) {
        char[] chars = s.toCharArray();
        boolean ans_of_test[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i ; j < s.length(); j++) {
                ans_of_test[i][j] = test(chars, i, j);
            }
        }
        int dp[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (ans_of_test[0][i]){
                dp[i] = 0;
            } else {
                // 初始化采用最大距离，默认每个位点都要分割
                dp[i] = i;
                for (int len = 1; len <= i; len++) {
                    if (ans_of_test[len][i]) {
                        dp[i] = Math.min(dp[len - 1] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[s.length()-1];
    }

    public boolean test(char[] chars, int start, int end) {
        // end是包括在内的
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }
}
