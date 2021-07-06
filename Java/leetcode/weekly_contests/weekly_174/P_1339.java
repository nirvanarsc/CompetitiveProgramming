package leetcode.weekly_contests.weekly_174;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_1339 {

    static long[] size;
    static Map<TreeNode, Integer> idx;
    static int time;

    private static final int MOD = (int) (1e9 + 7);

    public int maxProduct(TreeNode root) {
        size = new long[(int) (1e5 + 5)];
        idx = new HashMap<>();
        time = 0;
        dfs(root);
        long res = 0;
        final long total = size[idx.get(root)];
        for (long subTree : size) {
            if (subTree != 0) {
                res = Math.max(res, (total - subTree) * subTree);
            }
        }
        return (int) (res % MOD);
    }

    private static void dfs(TreeNode node) {
        final int u = time;
        idx.put(node, time++);
        size[u] = node.val;
        for (TreeNode next : new TreeNode[] { node.left, node.right }) {
            if (next != null) {
                dfs(next);
                size[u] += size[idx.get(next)];
            }
        }
    }
}
