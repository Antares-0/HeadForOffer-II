package HeadForOffer_II.Q091_Q100;

public class Q097 {
    public static void main(String[] args) {
        Q097 i = new Q097();
        System.out.println(i.numDistinct("babgbag", "bag"));
    }


    public int numDistinct(String s, String t) {
        // 长度检测边界限制
        int[][] answer = new int[t.length() + 1][s.length() + 1];
        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();
        // 初始化
        for (int k = 0; k <= s.length(); k++) answer[0][k] = 1;

        for (int j = 0; j < t.length(); j++) {
            for (int i = j; i < s.length(); i++) {
                if (chars_s[i] == chars_t[j]) {
                    answer[j + 1][i + 1] = answer[j][i] + answer[j + 1][i];
                } else {
                    answer[j + 1][i + 1] = answer[j + 1][i];
                }
            }
        }
        return answer[t.length()][s.length()];
    }

}
