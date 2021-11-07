package HeadForOffer_II.Q001_Q010;

public class Q005 {
    public static void main(String[] args) {

    }

    public int maxProduct(String[] words) {
        boolean[][] ans = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()){
                int loc = c - 'a';
                ans[i][loc] = true;
            }
        }
        int answer = 0;
        for(int i = 0;i< words.length;i++){
            for(int j = i+1;j< words.length;j++){
                int k = 0;
                for(;k < 26;k++){
                    if(ans[i][k] && ans[j][k]){
                        break;
                    }
                }
                if (k == 26){
                    answer = Math.max(words[i].length() * words[j].length(),answer);
                }
            }
        }
        return answer;
    }

}
