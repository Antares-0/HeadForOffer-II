package HeadForOffer_II.Q001_Q010;

public class Q001 {
    public static void main(String[] args) {
        System.out.println(divide(34,5));
    }

    public static int divide(int a, int b) {
        int change = 2;
        if (a < 0) {
            change--;
            a = -a;
        }
        if (b < 0) {
            change--;
            b = -b;
        }
        int k = divideCore(a,b);
        return change == 1 ? -k:k;
    }

    public static int divideCore(int big, int small) {
        int ans = 0;

        while (big > small){
            int value =  small;
            int count = 1;
            while (big > value + value){
                value = 2* value;
                count = count *2;
            }
            ans = ans + count;
            big = big - value;
        }
        return ans;
    }


}
