package HeadForOffer_II.Q061_Q070;

import java.util.List;

public class Q063 {
    public static void main(String[] args) {

    }

    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;

        public TrieNode() {
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        // 创建字典树的根节点
        TrieNode root = new TrieNode();
        // 添加节点
        for (String k : dictionary){
            TrieNode cur = root;
            for (char ch : k.toCharArray()){
                if (cur.children[ch - 'a'] == null){
                    TrieNode node = new TrieNode();
                    cur.children[ch - 'a'] = node;
                    cur = node;
                } else {
                    cur = cur.children[ch - 'a'];
                }
                cur.isWord = true;
            }
        }
        // 遍历句子
        String[] word_of_sentence = sentence.split(" ");
        for (int i = 0;i<word_of_sentence.length;i++){
            String w = search(root,word_of_sentence[i]);
            if (w.isEmpty()){

            } else {
                word_of_sentence[i] = w;
            }
        }
        return String.join(" ",word_of_sentence);

    }

    public String search (TrieNode root,String word){
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()){
            if (cur.children[ch - 'a'] == null){
                if (cur.isWord){
                    break;
                }
                return "";
            } else {
                sb.append(ch);
                cur = cur.children[ch - 'a'];
            }
        }
        return sb.toString();
    }

}
