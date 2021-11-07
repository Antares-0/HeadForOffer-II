package HeadForOffer_II.Q091_Q100;

import java.util.ArrayList;
import java.util.List;

public class Q100 {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> ceiling = new ArrayList<>();
        List<Integer> floor = new ArrayList<>();
        for (List<Integer> list : triangle) {
            if (list.size() == 1) {
                ceiling = list;
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (i == 0) {
                        floor.add(list.get(0) + ceiling.get(0));
                    } else if (i == list.size() - 1) {
                        floor.add(list.get(i) + ceiling.get(i - 1));
                    } else {
                        floor.add(Math.min(ceiling.get(i - 1), ceiling.get(i)) + list.get(i));
                    }
                    ceiling = floor;
                    floor = new ArrayList<>();
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i : ceiling) {
            ans = Math.min(ans, i);
        }
        return ans;
    }

}
