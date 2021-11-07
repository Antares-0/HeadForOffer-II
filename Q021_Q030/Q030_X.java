package HeadForOffer_II.Q021_Q030;

import java.util.ArrayList;
import java.util.HashMap;

public class Q030_X {
    public static void main(String[] args) {

    }
    class RandomizedSet {
        ArrayList<Integer> arr ;
        HashMap<Integer,Integer> map ;


        public RandomizedSet() {
            arr = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)){
                return false;
            }
            //有区别
            arr.add(val);


            map.put(val,arr.size());

            return true;

        }

        public boolean remove(int val) {
            if (map.containsKey(val)){
                // 有区别
                int p = map.get(val) - 1;
                // 有区别
                map.put(arr.get(arr.size() - 1),p + 1);
                map.remove(val);
                arr.set(p,arr.get(arr.size() - 1));
                arr.remove(arr.size()-1);
                return true;
            }else {
                return false;
            }

        }

        public int getRandom() {
            int random = (int)((1 - Math.random()) * map.size());
            return arr.get(random);
        }
    }
}
