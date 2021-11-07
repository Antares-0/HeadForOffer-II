package HeadForOffer_II.Q031_Q040;

import java.util.HashMap;
import java.util.Set;

public class Q032 {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map_s = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            map_s.put(s.charAt(i),map_s.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0;i<t.length();i++){
            if (!map_s.containsKey(t.charAt(i))){
                return false;
            } else {
                map_s.put(t.charAt(i),map_s.get(t.charAt(i)) - 1);
            }
        }
        Set<Character> characters = map_s.keySet();
        for (char c : characters){
            if (map_s.get(c) != 0){
                return false;
            }
        }

        return true;
    }

}
