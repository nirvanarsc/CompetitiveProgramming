package hard;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.UnionFind;

public class P_128 {

    public int longestConsecutive(int[] nums) {
        final Map<Integer, Integer> seen = new HashMap<>();
        final UnionFind uf = new UnionFind(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i])) { continue; }
            if (seen.containsKey(nums[i] - 1)) { uf.union(i, seen.get(nums[i] - 1)); }
            if (seen.containsKey(nums[i] + 1)) { uf.union(i, seen.get(nums[i] + 1)); }
            seen.put(nums[i], i);
        }
        int res = 0;
        for (int sz : uf.size()) {
            res = Math.max(res, sz);
        }
        return res;
    }
}
