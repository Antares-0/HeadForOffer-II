package HeadForOffer_II.Q051_Q060;

import java.util.HashMap;
import java.util.Map;

public class Q057 {
    public static void main(String[] args) {
        Q057 i = new Q057();
        int nums [] = {1,5,9,1,5,9};
        System.out.println(i.containsNearbyAlmostDuplicate(nums,2,3));
    }
    // t is the value between nums[a] and nums[b]
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer,Integer> map = new HashMap();
        if (t == 0){
            for (int i = 0;i<nums.length;i++){
                if (map.containsKey(nums[i])){
                    return true;
                }
                map.put(nums[i],0);
                if (map.size() > k){
                    map.remove(nums[i - k]);
                }
            }
            return false;
        }
        for (int i = 0; i< nums.length;i++){
            int id = getBucketID(nums[i],t);
            if (map.containsKey(id) ||
                    (map.containsKey(id + 1) && Math.abs(map.get(id + 1) + t) >= nums[i]) ||
                    (map.containsKey(id - 1) && Math.abs(map.get(id - 1) - t) <= nums[i]) ){
                return true;
            }
            map.put(id,nums[i]);
            if (map.size() > k){
                map.remove(getBucketID(nums[i - k],t));
            }
        }
        return false;

    }

    public int getBucketID(int num,int t){
        return num > 0 ? num / t : (num / t) - 1;
    }

}
