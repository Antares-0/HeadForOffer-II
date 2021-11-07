package HeadForOffer_II.Q011_Q020;

public class Q014 {
    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        int count[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            count[s2.charAt(i) - 'a']--;
        }
        if (AreAllZero(count)){
            return true;
        }
        for (int start = 0; start < s2.length() - s1.length(); start++) {
            int end = start + s1.length() - 1; // 下标
            if (AreAllZero(count)){
                return true;
            }
            end++;
            count[s2.charAt(start) - 'a']++;
            count[s2.charAt(end) - 'a']--;
        }
        return false;

    }

    public boolean AreAllZero (int [] nums){
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=0){
                return false;
            }
        }
        return true;
    }


}
