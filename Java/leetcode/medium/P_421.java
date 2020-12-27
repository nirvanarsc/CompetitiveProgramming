package leetcode.medium;

public class P_421 {

    private static class Trie {
        Trie[] children = new Trie[2];
    }

    public int findMaximumXOR(int[] nums) {
        final Trie root = new Trie();
        int res = 0;
        for (int num : nums) {
            add(root, num);
        }
        for (int num : nums) {
            res = Math.max(res, maxXor(root, num));
        }
        return res;
    }

    private static void add(Trie root, int num) {
        Trie curr = root;
        for (int i = 31; i >= 0; i--) {
            final int currBit = (num >> i) & 1;
            if (curr.children[currBit] == null) {
                curr.children[currBit] = new Trie();
            }
            curr = curr.children[currBit];
        }
    }

    private static int maxXor(Trie root, int num) {
        Trie curr = root;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int currBit = (num >> i) & 1;
            if (curr.children[currBit ^ 1] != null) {
                res |= 1 << i;
                currBit ^= 1;
            }
            curr = curr.children[currBit];
        }
        return res;
    }
}
