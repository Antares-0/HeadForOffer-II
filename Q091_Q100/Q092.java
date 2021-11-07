package HeadForOffer_II.Q091_Q100;

public class Q092 {
    public static void main(String[] args) {

    }

    public int minFlipsMonoIncr(String s) {
        // dp_1代表以0结尾的最小变化次数
        int dp_1 [] = new int[s.length() + 1];
        // dp_2代表以1结尾的最小变化次数
        int dp_2 [] = new int[s.length() + 1];
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i) == '0'){
                dp_1[i + 1] = dp_1[i];
                dp_2[i + 1] = Math.min(dp_1[i], dp_2[i]) + 1;
            } else if (s.charAt(i) == '1'){
                dp_1[i + 1] = dp_1[i] + 1;
                dp_2[i + 1] = Math.min(dp_1[i], dp_2[i]);
            }
        }
        return Math.min(dp_1[s.length()],dp_2[s.length()]);
    }
}
