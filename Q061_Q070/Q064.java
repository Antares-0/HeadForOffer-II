package HeadForOffer_II.Q061_Q070;

public class Q064 {
    public static void main(String[] args) {

    }

    class MagicDictionary {

        public class TrieNode {
            TrieNode children[] = new TrieNode[26];
            boolean isWord;

            public TrieNode() {
            }
        }

        /**
         * Initialize your data structure here.
         */
        TrieNode root;

        public MagicDictionary() {
            root = new TrieNode();
        }

        public void buildDict(String[] dictionary) {
            for (String k : dictionary) {
                TrieNode cur = root;
                for (char ch : k.toCharArray()) {
                    if (cur.children[ch - 'a'] == null) {
                        TrieNode node = new TrieNode();
                        cur.children[ch - 'a'] = node;
                        cur = node;
                    } else {
                        cur = cur.children[ch - 'a'];
                    }
                }
                cur.isWord = true;
            }
        }

        public boolean search(String searchWord) {
            return dfs(root,0,searchWord,0);
        }

        public boolean dfs(TrieNode root, int edit, String word, int i) {
            if (root == null) {
                return false;
            }
            if (root.isWord && edit == 1 && i == word.length()) {
                return true;
            }
            if (i < word.length() && edit <= 1) {
                boolean found = false;
                for (int j = 0; j < 26 && !found; j++) {
                    int next = j + 'a' == word.charAt(i) ? edit : edit + 1;
                    found = dfs(root.children[j], next,word,i + 1);
                }
                return found;

            }
            return false;
        }
    }

}
