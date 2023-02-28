package leetcode.weekly_contests.weekly_0_99.weekly_43;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_652 {

    static Map<String, Integer> map;
    static List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

    private static String dfs(TreeNode node) {
        if (node == null) {
            return "#";
        }
        final String key = node.val + "," + dfs(node.left) + ',' + dfs(node.right);
        if (map.merge(key, 1, Integer::sum) == 2) {
            res.add(node);
        }
        return key;
    }
}
