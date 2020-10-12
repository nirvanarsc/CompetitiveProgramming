package leetcode.weekly_contests.weekly_47;

import java.util.HashMap;
import java.util.Map;

public class P_666 {

    public int pathSum(int[] nums) {
        final Map<Integer, Integer> tree = new HashMap<>();
        for (int num : nums) {
            tree.put(num / 10, num % 10);
        }
        final int[] sum = { 0, 0 };
        dfs(nums[0] / 10, tree, sum);
        return sum[1];
    }

    private static void dfs(int root, Map<Integer, Integer> tree, int[] sum) {
        final int level = root / 10;
        final int pos = root % 10;
        final int left = (level + 1) * 10 + pos * 2 - 1;
        final int right = (level + 1) * 10 + pos * 2;
        sum[0] += tree.get(root);
        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum[1] += sum[0];
        }
        if (tree.containsKey(left)) {
            dfs(left, tree, sum);
        }
        if (tree.containsKey(right)) {
            dfs(right, tree, sum);
        }
        sum[0] -= tree.get(root);
    }
}
