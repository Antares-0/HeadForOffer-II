package HeadForOffer_II.Q011_Q020;

public class Q018 {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toUpperCase();
        while (i<j){
            if (!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            } else {
                if (s.charAt(i)!=s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

}
