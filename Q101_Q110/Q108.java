package HeadForOffer_II.Q101_Q110;

import java.util.*;

public class Q108 {
    public static void main(String[] args) {

    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> visited = new HashSet<>(wordList);
        // 对于双向遍历这句话是必须的，因为对尾节点进行双向遍历不能保证为尾节点真的出现在set中
        if (!visited.contains(endWord)){
            return 0;
        }
        set1.add(beginWord);
        set2.add(endWord);
        int length = 2;
        // visited.remove(endWord);
        while (!set1.isEmpty() && !set2.isEmpty()) {
            if (set1.size() > set2.size()) {
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }
            Set<String> set3 = new HashSet<>();
            for (String k : set1) {
                List<String> list = findNeighbor(k);
                for (String m : list){
                    if (set2.contains(m)){
                        return length;
                    }
                    if (visited.contains(m)){
                        visited.remove(m);
                        set3.add(m);
                    }
                }
            }
            // 处理衔接问题
            length ++;
            set1 = set3;
        }
        return 0;
    }

    private List<String> findNeighbor(String word) {
        List<String> list = new ArrayList<>();
        char chars [] = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char old = chars[i];
            for (int p = 0;p<26;p++){
                if (p + 'a' != old){
                    chars[i] = (char) (p + 'a');
                    list.add(new String(chars));
                }
            }
            chars[i] = old;
        }
        return list;
    }



}
