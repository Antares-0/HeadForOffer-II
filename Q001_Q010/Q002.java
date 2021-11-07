package HeadForOffer_II.Q001_Q010;

public class Q002 {
    public static void main(String[] args) {
        Q002 i = new Q002();
        String s = i.addBinary("101010", "1010101001");
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int index_a = a.length() - 1;
        int index_b = b.length() - 1;
        int carry = 0;
        while (index_a >= 0 || index_b >= 0) {
            int m = index_a >= 0 ? a.charAt(index_a--) - '0' : 0;
            int n = index_b >= 0 ? b.charAt(index_b--) - '0' : 0;
            int ans = m + n + carry;
            carry = ans == 2 ? 1 : 0;
            ans = ans>=2? ans-2: ans;
            sb.append(ans);
        }
        if (carry > 0){
            sb.append(1);
        }
        return sb.reverse().toString();


    }
}
