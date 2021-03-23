package leetcode.weekly_contests.weekly_233;

public class P_1803 {

    private static class Trie {
        Trie[] c = new Trie[2];
        int count;
    }

    private static void add(int num, Trie root) {
        Trie iter = root;
        for (int i = 15; i >= 0; i--) {
            final int bit = (num >> i) & 1;
            if (iter.c[bit] == null) {
                iter.c[bit] = new Trie();
            }
            iter = iter.c[bit];
            iter.count++;
        }
    }

    private static int f(Trie root, int n, int k) {
        int res = 0;
        for (int i = 15; i >= 0 && root != null; i--) {
            final int x = (n >> i) & 1;
            final int y = (k >> i) & 1;
            if (y == 1) {
                if (root.c[x] != null) {
                    res += root.c[x].count;
                }
                root = root.c[1 ^ x];
            } else {
                root = root.c[x];
            }
        }
        return res;
    }

    public int countPairs(int[] nums, int low, int high) {
        final Trie root = new Trie();
        int lo = 0;
        int hi = 0;
        for (int num : nums) {
            hi += f(root, num, high + 1);
            lo += f(root, num, low);
            add(num, root);
        }
        return hi - lo;
    }
}
