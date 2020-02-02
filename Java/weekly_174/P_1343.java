package weekly_174;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_1343 {

    private static final int MOD = (int) (1e9 + 7);

    public int maxProduct(TreeNode root) {
        final List<Long> sums = new ArrayList<>();
        final long total = dfs(root, sums);
        long res = 0;
        for (long sum : sums) {
            res = Math.max(res, sum * (total - sum));
        }
        return (int) (res % MOD);
    }

    public long dfs(TreeNode node, List<Long> sums) {
        if (node == null) {
            return 0;
        }
        final long curr = node.val + dfs(node.left, sums) + dfs(node.right, sums);
        sums.add(curr);
        return curr;
    }
}
