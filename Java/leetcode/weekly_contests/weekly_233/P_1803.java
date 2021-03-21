package leetcode.weekly_contests.weekly_233;

public class P_1803 {

    private static class Trie {
        Trie left;
        Trie right;
        Trie up;
        long count = 1;
    }

    private static void update(Trie root) {
        long count = 0;
        count += root.left == null ? 0 : root.left.count;
        count += root.right == null ? 0 : root.right.count;
        root.count += count;

        if (root.up != null) {
            update(root.up);
        }
    }

    private static void add(int num, int level, Trie root) {
        if (level == -1) {
            update(root);
            return;
        }
        if ((num & (1 << level)) != 0) {
            if (root.right == null) {
                final Trie c = new Trie();
                root.right = c;
                c.up = root;
            }
            add(num, level - 1, root.right);
        } else {
            if (root.left == null) {
                final Trie c = new Trie();
                root.left = c;
                c.up = root;
            }
            add(num, level - 1, root.left);
        }
    }

    public int countPairs(int[] nums, int low, int high) {
        final int h = 16;
        final Trie root = new Trie();
        add(0, 16, root);
        final long[] hi = { 0 };
        for (int num : nums) {
            dfs(num, high, h, root, hi);
            add(num, h, root);
        }
        final Trie root2 = new Trie();
        add(0, 16, root2);
        final long[] lo = { 0 };
        for (int num : nums) {
            dfs(num, low, h, root2, lo);
            add(num, h, root2);
        }
        return (int) (hi[0] - lo[0]);
    }

    private static void dfs(int num, int k, int level, Trie root, long[] ans) {
        if (level == -1) {
            return;
        }
        if ((num & (1 << level)) != 0) {
            if ((k & (1 << level)) != 0) {
                if (root.right != null) {
                    ans[0] += root.right.count;
                }
                if (root.left != null) {
                    dfs(num, k, level - 1, root.left, ans);
                }
            } else {
                if (root.right != null) {
                    dfs(num, k, level - 1, root.right, ans);
                }
            }
        } else {
            if ((k & (1 << level)) != 0) {
                if (root.left != null) {
                    ans[0] += root.left.count;
                }
                if (root.right != null) {
                    dfs(num, k, level - 1, root.right, ans);
                }
            } else {
                if (root.left != null) {
                    dfs(num, k, level - 1, root.left, ans);
                }
            }
        }
    }
}
