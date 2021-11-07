package HeadForOffer_II.Q011_Q020;

import java.util.HashMap;

public class Q017 {
    public static void main(String[] args) {

    }
    public String minWindow(String s, String t) {
        // t是字串，s是母串
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) + 1);
        }
        int ans = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        int start_ans = 0;
        int end_ans = 0;
        while (end < s.length()) {
            if (!AreAllNonPos(map)) {
                end++;
                if (end == s.length()){
                    break;
                }
                if (map.containsKey(s.charAt(end))) {
                    map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
                }
            } else {
                if (end - start < ans) {
                    start_ans = start;
                    end_ans = end;
                }
                ans = Math.min(ans, end - start);
                start++;
                if (map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                }
            }
        }
        return s.substring(start_ans + 1,end_ans+ 1);
    }

    public boolean AreAllNonPos(HashMap<Character, Integer> map) {
        for (int k : map.values()){
            if (k>0){
                return false;
            }
        }
        return true;
    }
}
