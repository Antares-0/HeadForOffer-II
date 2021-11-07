package HeadForOffer_II.Q011_Q020;


import java.util.HashMap;
import java.util.Map;

public class Q011 {
    public static void main(String[] args) {
        int num [] = {0,1,0};
        Q011 i = new Q011();
        System.out.println(i.findMaxLength(num));
    }
    public int findMaxLength(int[] nums) {
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int count =0;
        for (int i = 0; i<nums.length;i++){
            sum += nums[i]==0 ? -1 : 1;
            if (map.containsKey(sum)){
                count = Math.max(count, i-map.get(sum));
            } else {
                map.put(sum,i);
            }
        }
        return count;
    }

}
