package HeadForOffer_II.Q061_Q070;

public class Q067 {


    public class TrieNode {
        TrieNode children[];

        public TrieNode() {
            children = new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int flag = num >> i & 1;
                if (cur.children[flag] == null) {
                    TrieNode node = new TrieNode();
                    cur.children[flag] = node;
                    cur = node;
                } else {
                    cur = cur.children[flag];
                }
            }
        }
        int max = 0;
        for (int num : nums) {
            TrieNode cur = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int flag = num >> i & 1;
                if (cur.children[1 - flag] != null) {
                    xor = (xor << 1) + 1;
                    cur = cur.children[1-flag];
                } else {
                    xor = xor << 1;
                    cur = cur.children[flag];
                }
            }
            max = Math.max(max,xor);
        }

        return max;
    }

}
