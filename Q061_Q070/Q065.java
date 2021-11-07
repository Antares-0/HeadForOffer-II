package HeadForOffer_II.Q061_Q070;

import java.util.HashSet;
import java.util.Set;

public class Q065 {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String mm = word.substring(words.length - 1 - i, words.length - 1);
                if (set.contains(mm)) {
                    set.remove(mm);
                }
            }
        }
        int sum  = 0;
        for (String s : set){
            sum += s.length();
        }
        return sum + set.size();
    }
}
