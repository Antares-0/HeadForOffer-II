package HeadForOffer_II.Q091_Q100;

import java.util.HashMap;

public class Q093 {
    public static void main(String[] args) {

    }

    public int lenLongestFibSubseq(int[] arr) {
        // 值、位置
        HashMap<Integer, Integer> map = new HashMap<>();
        int dp[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int i_log = i;
                int j_log = j;
                int count = 2;
                if (map.containsKey(arr[i_log] + arr[j_log])) {
                    while (map.containsKey(arr[i_log] + arr[j_log])) {
                        int log = map.get(arr[i_log] + arr[j_log]);
                        i_log = j_log;
                        j_log = log;
                        count++;
                    }
                    max = Math.max(count, max);
                }
            }
        }
        return max;
    }

}
