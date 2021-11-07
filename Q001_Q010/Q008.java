package HeadForOffer_II.Q001_Q010;

public class Q008 {
    public static void main(String[] args) {

    }
    public int minSubArrayLen( int target,int[] nums) {
        int P_1 = 0;
        int P_2 = 0;
        int len = Integer.MAX_VALUE;
        while(P_2 < nums.length){
            if (SUM_OF_ARRAY(nums,P_1,P_2)<target){
                P_2 ++;
            } else if(SUM_OF_ARRAY(nums,P_1,P_2) >= target){
                len = Math.min(len,P_2-P_1+1);
                P_1 ++;
            }
        }

        return len == Integer.MAX_VALUE? 0:len;
    }

    public int SUM_OF_ARRAY(int[]nums,int start,int end){
        int sum = 0;
        int len = end-start;
        for(int i= 0;i<len+1;i++){
            sum+=nums[i+start];
        }
        return sum;
    }

}
