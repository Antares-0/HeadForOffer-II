package HeadForOffer_II.Q091_Q100;

public class Q091 {
    public static void main(String[] args) {

    }

    public int minCost(int[][] costs) {
        int[] dp_1 = new int[costs.length + 1];
        int[] dp_2 = new int[costs.length + 1];
        int[] dp_3 = new int[costs.length + 1];
        dp_1[0] = 0;
        dp_2[0] = 0;
        dp_3[0] = 0;
        for (int i = 1; i <= costs.length; i++) {
            dp_1[i] = Math.min(dp_2[i-1],dp_3[i-1]) + costs[i-1][0];
            dp_2[i] = Math.min(dp_1[i-1],dp_3[i-1]) + costs[i-1][1];
            dp_3[i] = Math.min(dp_1[i-1],dp_2[i-1]) + costs[i-1][2];
        }
        return Math.min(dp_1[costs.length],Math.min(dp_2[costs.length], dp_3[costs.length]));
    }
}
