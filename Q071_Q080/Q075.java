package HeadForOffer_II.Q071_Q080;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Q075 {
    public static void main(String[] args) {

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 使用hash表记录
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr2) {
            map.put(num, 0);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            if (map.containsKey(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                list.add(num);
            }
        }
        int ans[] = new int[arr1.length];
        int index_of_ans = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (map.get(arr2[i]) != 0) {
                ans[index_of_ans] = arr2[i];
                map.put(arr2[i], map.get(arr2[i]) - 1);
                index_of_ans++;
            }
        }
        Collections.sort(list);
        for (int i = 0 ;i<list.size();i++){
            ans[index_of_ans] = list.get(i);
            index_of_ans++;
        }
        return ans;
    }
}
