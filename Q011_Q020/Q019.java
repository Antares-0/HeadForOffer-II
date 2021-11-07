package HeadForOffer_II.Q011_Q020;

public class Q019 {
    public static void main(String[] args) {

    }
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        boolean flag_i = true;
        boolean flag_j = true;
        while (s.charAt(i) == s.charAt(j) && i<j) {
            i++;
            j--;
        }
        // 记录i，j的位置
        int log_i = i;
        int log_j = j;
        i ++;
        while(i<j){
            if (s.charAt(j)!=s.charAt(i)){
                flag_i = false;
            }
            i++;
            j--;
        }
        i = log_i;
        j = log_j - 1;
        while(i<j){
            if (s.charAt(j)!=s.charAt(i)){
                flag_j = false;
            }
            i++;
            j--;
        }
        return flag_i||flag_j;
    }
}
