package leetcode.weekly_contests.weekly_221;

import java.util.Arrays;
import java.util.Comparator;

public class P_1707 {

    private static class Trie {
        Trie[] children = new Trie[2];
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        final Trie root = new Trie();
        final int[][] q = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            q[i] = new int[] { queries[i][0], queries[i][1], i };
        }
        Arrays.sort(nums);
        Arrays.sort(q, Comparator.comparingInt(val -> val[1]));
        int idx = 0;
        final int n = nums.length;
        final int[] res = new int[queries.length];
        for (int[] query : q) {
            final int x = query[0];
            final int m = query[1];
            final int i = query[2];
            while (idx < n && nums[idx] <= m) {
                add(root, nums[idx++]);
            }
            if (nums[0] > m) {
                res[i] = -1;
            } else {
                res[i] = maxXor(root, x);
            }
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
