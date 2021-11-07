package HeadForOffer_II.Q081_Q090;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q086 {
    public static void main(String[] args) {
        Q086 i = new Q086();
        System.out.println(i.partition("aab"));
    }

    public String [][] partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(0, s, new LinkedList<>(), ans);



        // 将ans转变为[][]
        String [][] ss = new String[ans.size()][];


        int i = 0;
        for (List<String> mm : ans){
            ss[i] = mm.toArray(new String[mm.size()]);
            i++;
        }
        return ss;
    }

    private void dfs(int index, String s, LinkedList<String> list, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new LinkedList<>(list));
        }
        for (int i = index; i < s.length(); i++) {
            if (test(s, index, i)) {
                list.add(s.substring(index, i + 1));
                dfs(i + 1, s, list, ans);
                list.removeLast();
            }
        }
    }

    private boolean test(String s, int start, int end) {
        char a[] = s.toCharArray();
        while (start < end) {
            if (a[start] != a[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

//    public List<List<String>> Par (String s){
//        List<List<String>> ans = new ArrayList<>();
//        helper(s,0,new LinkedList<>(),ans);
//        return ans;
//    }
//
//    private void helper(String str, int start, LinkedList<String> list, List<List<String>> ans){
//        if (start == str.length()){
//            ans.add(new LinkedList<>(list));
//        } else {
//            for (int i = start; i<str.length();i++){
//                if (ispal(str,start,i)){
//                    list.add(str.substring(start,i+1));
//                    helper(str,i+1,list,ans);
//                    list.removeLast();
//                }
//            }
//        }
//    }
//
//    private boolean ispal(String str,int start,int end){
//        while(start < end){
//            if (str.charAt(start++) != str.charAt(end--)){
//                return false;
//            }
//        }
//        return true;
//    }


}
