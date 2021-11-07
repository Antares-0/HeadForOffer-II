package HeadForOffer_II.Q071_Q080;

public class Q072 {
    public static void main(String[] args) {

    }


    // 牛顿迭代、换底没有普遍性意义
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        while (start <= end){
            long mid = (start + end) / 2;
            if (mid * mid > x){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int)end;
    }

}
