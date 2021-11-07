package HeadForOffer_II.Q001_Q010;

public class Q004 {
    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,2,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int[] ans = new int[32];

        for (int num: nums) {
            for (int j = 0; j < 32; j++) {
                ans[j] = ans[j] + ((num >> (31 - j)) & 1);
            }
        }
        int answer = 0;

        for (int n = 0; n < 32; n++) {
            answer = (answer << 1) + ans[n] % 3;
        }
        return answer;
    }


}
