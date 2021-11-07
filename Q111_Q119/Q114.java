package HeadForOffer_II.Q111_Q119;

import java.util.*;

public class Q114 {
    public static void main(String[] args) {

    }

    public String alienOrder(String[] words) {
        Map<Character,Set<Character>> graph = new HashMap<>();
        Map<Character,Integer> inDegree = new HashMap<>();
        for (String word : words){
            for (char ch : word.toCharArray()){
                graph.putIfAbsent(ch,new HashSet<>());
                inDegree.put(ch,0);
            }
        }

        for (int i = 0;i< words.length - 1;i++){
            String s1 = words[i];
            String s2 = words[i + 1];
            if (s1.startsWith(s2) && !s1.equals(s2)){
                return "";
            }

            for (int loc = 0;loc < s1.length() && loc < s2.length();loc++){
                if (s1.charAt(loc) != s2.charAt(loc)){
                    if (!graph.get(s1.charAt(loc)).contains(s2.charAt(loc))){ // ? 很重要的，保证了相连的边不会被计算两次
                        graph.get(s1.charAt(loc)).add(s2.charAt(loc));
                        inDegree.put(s2.charAt(loc), inDegree.get(s2.charAt(loc)) + 1); // ?
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char ch : inDegree.keySet()){
            if (inDegree.get(ch) == 0){
                queue.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            char log = queue.poll();
            sb.append(log);
            for (char ch : graph.get(log)){
                inDegree.put(ch,inDegree.get(ch) - 1);
                if (inDegree.get(ch) == 0){
                    queue.add(ch);
                }
            }
        }
        return sb.length() == graph.size() ? sb.toString() : "";
    }

}
