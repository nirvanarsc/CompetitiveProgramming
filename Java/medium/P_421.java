package medium;

public class P_421 {

    static class Trie {
        Trie[] children;

        Trie() {
            children = new Trie[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        final Trie root = new Trie();
        int res = 0;
        for (int num : nums) {
            Trie curr = root;
            for (int i = Integer.SIZE - 1; i >= 0; i--) {
                final int curBit = (num >> i) & 1;
                if (curr.children[curBit] == null) {
                    curr.children[curBit] = new Trie();
                }
                curr = curr.children[curBit];
            }
        }
        for (int num : nums) {
            Trie curr = root;
            int currSum = 0;
            for (int i = Integer.SIZE - 1; i >= 0; i--) {
                final int curBit = (num >> i) & 1;
                if (curr.children[curBit ^ 1] != null) {
                    currSum += 1 << i;
                    curr = curr.children[curBit ^ 1];
                } else {
                    curr = curr.children[curBit];
                }
            }
            res = Math.max(currSum, res);
        }
        return res;
    }
}
