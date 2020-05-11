package weekly_contests.weekly_18a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_508 {

    public static final int[] INTS = new int[0];

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return INTS;
        }
        final Map<Integer, Integer> freq = new HashMap<>();
        dfs(root, freq);
        final List<Integer> res = new ArrayList<>();
        final int max = Collections.max(freq.values());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int dfs(TreeNode node, Map<Integer, Integer> freq) {
        if (node == null) {
            return 0;
        }
        final int left = dfs(node.left, freq);
        final int right = dfs(node.right, freq);
        freq.merge(left + right + node.val, 1, Integer::sum);
        return left + right + node.val;
    }
}
