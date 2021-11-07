package HeadForOffer_II.Q051_Q060;

import java.util.TreeMap;

public class Q058 {
     public static void main(String[] args) {

    }


    class MyCalendar {
        TreeMap<Integer,Integer> map;
        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            if (map.isEmpty()){
                map.put(start,end);
                return true;
            }
            else {
                if ((map.ceilingKey(start)!=null && (end > map.ceilingKey(start)))){
                    return false;
                } else if (map.floorKey(start)!=null && map.get(map.floorKey(start)) > start){
                    return false;
                } else {
                    map.put(start,end);
                    return true;
                }
            }
        }
    }
}
