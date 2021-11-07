package HeadForOffer_II.Q011_Q020;

public class Q020 {
    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        int i;
        int j = 0;
        int count = 0;
        while (j<s.length()){
            i = 0;
            while(i<j) {
                if (isPal(s, i, j)) {
                    count++;
                }
                i = Math.min(s.indexOf(s.charAt(j), i + 1), j);
            }
            count++;
            j++;
        }
        return count;
    }

    private boolean isPal(String s, int start, int end){
        // start<=end 或者 start<end 都可以
        // 实际上这段代码不是非常的健壮，因为如果start和end是负数或者其他什么情况，就会无法正常运行
        // 因此在书写代码的时候必须要注意每一个函数的具体条件
        for (;start<end;start++,end--){
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
        }
        return true;
    }

}
