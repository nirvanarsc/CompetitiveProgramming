package leetcode.weekly_contests.weekly_300_399.weekly_371;

import java.util.Arrays;

public class P_4 {

    private static class Trie {
        int v;
        Trie[] c = new Trie[2];
    }

    private static void add(Trie root, int num) {
        Trie curr = root;
        for (int i = 31; i >= 0; i--) {
            final int currBit = (num >> i) & 1;
            if (curr.c[currBit] == null) {
                curr.c[currBit] = new Trie();
                curr.c[currBit].v++;
            }
            curr = curr.c[currBit];
        }
    }

    private static void remove(Trie root, int num) {
        Trie curr = root;
        for (int i = 31; i >= 0; i--) {
            final int currBit = (num >> i) & 1;
            curr.c[currBit].v--;
            curr = curr.c[currBit];
        }
    }

    private static int maxXor(Trie root, int num) {
        Trie curr = root;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int currBit = (num >> i) & 1;
            if (curr.c[currBit ^ 1] != null && curr.c[currBit ^ 1].v > 0) {
                res |= 1 << i;
                currBit ^= 1;
            }
            curr = curr.c[currBit];
        }
        return res;
    }

    public int maximumStrongPairXor(int[] nums) {
        final int n = nums.length;
        final Trie root = new Trie();
        Arrays.sort(nums);
        int j = 0;
        int res = 0;
        for (int num : nums) {
            while (j < n && nums[j] <= 2 * num) {
                add(root, nums[j++]);
            }
            res = Math.max(res, maxXor(root, num));
            remove(root, num);
        }
        return res;
    }
}
