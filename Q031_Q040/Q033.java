package HeadForOffer_II.Q031_Q040;

import java.util.*;

public class Q033 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // 第一次知道，toCharArray的部分可以直接经过String变成内容
            String k = new String(chars);
            if (map.containsKey(k)){
                map.get(k).add(s);
            } else {
                List list = new ArrayList();
                list.add(s);
                map.put(k,list);
            }
        }
        Set<String> strings = map.keySet();
        for (String ss:strings){
            ans.add(map.get(ss));
        }
        return ans;
    }


}
