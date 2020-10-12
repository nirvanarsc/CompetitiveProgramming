package leetcode.weekly_contests.weekly_34;

import utils.DataStructures.UnionFind;

public class P_565 {

    public int arrayNesting(int[] nums) {
        final UnionFind uf = new UnionFind(nums.length);
        for (int i = 0; i < nums.length; i++) {
            uf.union(i, nums[i]);
        }
        int max = 0;
        for (int size : uf.size()) {
            max = Math.max(max, size);
        }
        return max;
    }
}
