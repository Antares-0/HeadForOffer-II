package HeadForOffer_II.Q001_Q010;

import static java.util.Arrays.sort;

public class Q006 {
    public static void main(String[] args) {

    }

    public int [] twoSum(int[] numbers, int target){
        sort(numbers);
        int start = 0;
        int end = numbers.length - 1;
        int ans [] = new int[2];
        for (int i = 0; i< numbers.length;i++){
            if (numbers[start] + numbers[end] == target && start < end ){
                ans[0] = start;
                ans[1] = end;

            } else if (numbers[start] + numbers[end] >= target){
                end--;
            } else {
                start++;
            }
        }
        return ans;
    }
}
