package HeadForOffer_II.Q061_Q070;

public class Q066 {
        class MapSum {

        public class TrieNode {
            TrieNode[] children;
            int val;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        TrieNode root;

        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode cur = root;
            for (char ch : key.toCharArray()) {
                if (cur.children[ch - 'a'] == null) {
                    TrieNode node = new TrieNode();
                    cur.children[ch - 'a'] = node;
                    cur = node;
                } else {
                    cur = cur.children[ch - 'a'];
                }
            }
            cur.val = val;
        }

        public int sum(String prefix) {
            int a [] = {0};
            TrieNode cur = root;
            for (char ch :prefix.toCharArray()){
                if (cur.children[ch - 'a'] == null) {
                    TrieNode node = new TrieNode();
                    cur.children[ch - 'a'] = node;
                    cur = node;
                } else {
                    cur = cur.children[ch - 'a'];
                }
            }
            dfs(cur,a);
            return a[0];
        }

        public void dfs(TrieNode root, int[] a) {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null){
                    dfs(root.children[i], a);
                }

            }
            // 注意，不是0就要添加，否则会漏掉一些内容
            if (root.val != 0){
                a[0] += root.val;
            }
        }
    }
}
