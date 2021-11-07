package HeadForOffer_II.Q061_Q070;

public class Q062 {

    class Trie {

        static class TrieNode {
            TrieNode children [];
            boolean isWord;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        // 字典树的根节点
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0;i < word.length();i++){
                if (cur.children[word.charAt(i)-'a'] == null){
                    TrieNode node = new TrieNode();
                    cur.children[word.charAt(i)-'a'] = node;
                    cur = node;
                } else {
                    cur = cur.children[word.charAt(i)-'a'];
                }
                if (i == word.length() - 1){
                    cur.isWord = true;
                }
            }
        }

        public boolean search(String word) {
            TrieNode cur = root;
            for (int i = 0;i<word.length();i++){
                if (cur.children[word.charAt(i) - 'a'] == null){
                    return false;
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            return cur.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (int i = 0;i<prefix.length();i++){
                if (cur.children[prefix.charAt(i) - 'a'] == null){
                    return false;
                }
                cur = cur.children[prefix.charAt(i) - 'a'];
            }
            return true;
        }
    }

}
