package HeadForOffer_II.Q001_Q010;

import java.util.HashMap;
import java.util.Map;

public class Q010 {
    public static void main(String[] args) {

    }


    /**
     * hashmap实现
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count =0;
        for(int num : nums){
            sum+=num;
            count+= map.getOrDefault(sum - k,0);
            map.put(sum,map.getOrDefault(sum,0));
        }
        return count;
    }

    /**
     * 两层for循环实现
     */
/*    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        int s = 0;
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            s+=nums[i];
            sum[i+1] = s;
        }
        int count = 0;
        for (int i = 0; i < sum.length;i++){
            for(int j = i+1;j< sum.length;j++){
                if (k == sum[j] - sum[i]){
                    count++;
                }
            }
        }
        return count;
    }*/
}
