package HeadForOffer_II.Q031_Q040;

import java.util.HashMap;

public class Q034 {
    public static void main(String[] args) {

    }
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i =0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }

        int last = -1;

        for (int i = 0;i< words.length;i++){
            if (last < map.get(words[i].charAt(0))){
                last = map.get(words[i].charAt(0));
            } else if (last == map.get(words[i].charAt(0))){
                String a_1 = words[i-1];
                String a_2 = words[i];
                int o = 1;
                boolean flag = false;
                while (o <a_1.length() && o<a_2.length()){
                    if (map.get(a_1.charAt(o)) < map.get(a_2.charAt(o))){
                        flag = true;
                        break;
                    } else if (map.get(a_1.charAt(o)) == map.get(a_2.charAt(o))){

                    }else {
                        return false;
                    }
                    o++;
                }
                if ((!flag) && o == a_2.length() && o<a_1.length()){
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
