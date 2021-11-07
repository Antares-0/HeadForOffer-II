package HeadForOffer_II.Q101_Q110;

import java.util.*;

public class Q109 {
    public static void main(String[] args) {

    }

    public int openLock(String[] deadends, String target) {
        Set<String> no = new HashSet<>();
        for (String s : deadends){
            no.add(s);
        }
        if (no.contains("0000")){
            return -1;
        }
        if (target.equals("0000")){
            return 0;
        }
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue1.offer("0000");
        Set<String> visited = new HashSet<>();
        int length = 1;
        while (!queue1.isEmpty()){
            int cur_size = queue1.size();
            for (int i = 0;i<cur_size;i++) {
                String log = queue1.poll();
                List<String> neighbors = findNeighbors(log);
                for (String neighbor : neighbors) {
                    if (neighbor.equals(target)) {
                        return length;
                    }
                    if (!no.contains(neighbor) && !visited.contains(neighbor)) {
                        queue2.add(neighbor);
                    }
                    visited.add(neighbor);
                }
            }
            length++;
            queue1 = queue2;
            queue2 = new LinkedList<>();
        }
        return -1;
    }

    private List<String> findNeighbors(String nums){
        char [] chars = nums.toCharArray();
        List<String> answer = new ArrayList<>();
        for (int i = 0;i<chars.length;i++){
            char old = chars[i];
            chars[i] = (char)('0' + (old - '0' + 1) % 10);
            answer.add(new String(chars));
            chars[i] = (char)('0' + (old - '0' + 9) % 10);
            answer.add(new String(chars));
            chars[i] = old;
        }
        return answer;
    }
}
