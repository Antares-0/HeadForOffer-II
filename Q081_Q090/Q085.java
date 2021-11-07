package HeadForOffer_II.Q081_Q090;

import java.util.ArrayList;
import java.util.List;

public class Q085 {
    public List<String> generateParenthesis(int n) {
        List<String> an = new ArrayList<>();
        dfs(n,n,new String(),an);
        return an;
    }

    private void dfs(int left, int right, String ans, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(new String(ans));
        }
        if (left > 0) {
            dfs(left--, right, ans + "(", list);
        }
        if (left < right) {
            dfs(left, right--, ans + ")", list);
        }

    }
}
