package HeadForOffer_II.Q111_Q119;

public class Q117 {
    public static void main(String[] args) {
        // 关键测试用例：["ogcgfg","ggcgfo","gocgfg"]

    }

    public int numSimilarGroups(String[] strs) {
        int fathers[] = new int[strs.length];
        // 初始化
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        // 遍历
        int count = strs.length;
        for (int i = 0; i < fathers.length; i++) {
            for (int j = i + 1; j < fathers.length; j++) {
                if (similarTest(strs[i], strs[j]) && Union(fathers,i,j)) {
                    count -- ;
                }
            }
        }
        return count;
    }
    // 该函数的作用在于，将两个元素相连，或者是叫检测两个元素是否已经相连
    private boolean Union(int [] fathers,int i, int j){
        int i_ = findFather(fathers,i);
        int j_ = findFather(fathers,j);
        if (i_ != j_){
            fathers[i_] = j_;
            // true表示没有相连，但是现在已经相连了
            return true;
        }
        // false表示已经相连了，不用再联合
        return false;
    }

    private int findFather(int [] fathers,int i){
        if (fathers[i] != i){
            fathers[i] = findFather(fathers,fathers[i]);
        }
        return fathers[i];
    }

    // 做麻烦了，没仔细看题，题中已经强调了是变位词，我这里的版本默认不是
    private boolean similarTest(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)){
            return true;
        }
        char[] crr_1 = s1.toCharArray();
        char[] crr_2 = s2.toCharArray();
        int count = 0;
        int loc1 = -1;
        int loc2 = -1;
        for (int i = 0; i < crr_1.length; i++) {
            if (crr_1[i] == crr_2[i]) {
                continue;
            } else {
                if (loc1 == -1) {
                    loc1 = i;
                } else {
                    loc2 = i;
                }
                count++;
            }
        }
        if (count != 2) {
            return false;
        }
        if (crr_1[loc1] == crr_2[loc2] && crr_1[loc2] == crr_2[loc1]) {
            return true;
        }
        return false;
    }

}
