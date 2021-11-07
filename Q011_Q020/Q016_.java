package HeadForOffer_II.Q011_Q020;

public class Q016_ {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = -1;
        boolean flag = false;
        int [] log = new int[256];
        int ans = 0;
        for (;i<s.length();i++){
            log[s.charAt(i)]++;
            if (log[s.charAt(i)] >= 2){
                flag = true;
            }
            while (flag) {
                j++;
                log[s.charAt(j)]--;
                if (log[s.charAt(j)] >= 1){
                    flag = false;
                }
            }
            ans = Math.max(ans,i-j);
        }
        return ans;
    }
}
