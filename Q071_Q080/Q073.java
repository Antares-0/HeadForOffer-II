package HeadForOffer_II.Q071_Q080;

public class Q073 {

    public int minEatingSpeed(int[] piles, int h) {
        int sum = 0;
        int max = 0;
        for (int banana : piles){
            max = Math.max(max,banana);
            sum += banana;
        }
        int start = sum / h > 0 ? sum / h : 1;
        int end = max;
        while (start <= end){
            int mid = start + (- start + end) / 2;
            int count = 0;
            for (int banana : piles){
                count += (banana + mid - 1)/mid;
            }
            if (count <= h){
                if (mid == 1){
                    return mid;
                }
                int count1 = 0;
                for (int banana : piles){
                    count1 += (banana + mid - 2)/(mid-1);
                }
                if (count1 > h){
                    return mid;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

}
