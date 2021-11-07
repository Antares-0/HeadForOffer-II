package HeadForOffer_II.Q081_Q090;

import java.util.ArrayList;
import java.util.List;

public class Q087 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() >= 13){
            return ans;
        }
        dfs(s,0,ans,new ArrayList<>());

        return ans;
    }

    private void dfs(String s, int index, List<String> ans, List<Integer> list) {
        // 如果已经是第四个合理的数
        if (index == s.length() && list.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (int num : list){
                sb.append(num);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() -1 );
            ans.add(sb.toString());
            return;
        } else if (index < s.length()) {
            for (int i = index; i < s.length(); i++) {
                if (isRightIP(s, index, i + 1)) {
                    list.add(Integer.parseInt(s.substring(index, i + 1)));
                    dfs(s, i + 1, ans, list);
                    list.remove(list.size() - 1);
                }
            }
        }

    }

    private boolean isRightIP(String s, int start, int end) {
        // end是末尾，但大于最后一位
        String num = s.substring(start, end);
        if (num.charAt(0) == '0' && num.length() > 1){
            return false;
        }
        if (num.length() >= 4){
            return false;
        }
        int log = Integer.parseInt(num);
        if (log >= 0 && log <= 255) {
            return true;
        } else {
            return false;
        }
    }
}
