package HeadForOffer_II.Q001_Q010;

import java.util.Arrays;

public class Q003 {
    public static void main(String[] args) {
        Arrays.stream(countBits(8)).forEach(System.out::println);
    }

    public static int[] countBits(int num){
        int [] ans = new int[num+1];
        for (int i = 1;i<=num;i++){
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

}
