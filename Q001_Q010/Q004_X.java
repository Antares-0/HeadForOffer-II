package HeadForOffer_II.Q001_Q010;

public class Q004_X {
    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,2,12,12};
        System.out.println(singleNumber(nums,3,2));

    }

    public static int singleNumber(int[] nums,int m,int n) {
        int[] ans = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                ans[i] += num >> (31 - i) & 1;
            }
        }
        int answer = 0;
        for (int j = 0; j < 32; j++) {
            answer = (answer<< 1) + ans[j]%m;
        }
        return answer/n;
    }

}
