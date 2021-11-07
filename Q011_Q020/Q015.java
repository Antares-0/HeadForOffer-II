package HeadForOffer_II.Q011_Q020;

import java.util.ArrayList;
import java.util.List;

public class Q015 {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        // p是子串
        // s是母串
        int log[] = new int[26];
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()){
            return list;
        }
        char[] chars_of_p = p.toCharArray();
        for (char i : chars_of_p) {
            log[i - 'a']++;
        }
        for (int i = 0;i<p.length();i++) {
            log[s.charAt(i) - 'a']--;
        }
        if (AreAllZero(log)){
            list.add(0);
        }
        int k = s.length() - p.length();
        int p_len = p.length();
        for (int i = 1; i < k; i++) {
            log[s.charAt(i-1) - 'a']++;
            log[s.charAt(i + p_len - 1) - 'a']--;
            if (AreAllZero(log)){
                list.add(i);
            }
        }
        return list;
    }

    public boolean AreAllZero(int[] nums) {
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }


}
