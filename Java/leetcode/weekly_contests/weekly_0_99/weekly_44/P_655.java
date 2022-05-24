package leetcode.weekly_contests.weekly_0_99.weekly_44;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utils.DataStructures.TreeNode;

public class P_655 {

    public List<List<String>> printTree(TreeNode root) {
        final int h = getHeight(root);
        final String[][] strings = new String[h][(1 << h) - 1];
        for (String[] row : strings) {
            Arrays.fill(row, "");
        }
        dfs(root, strings, 0, strings[0].length, 0);
        return Arrays.stream(strings)
                     .map(Arrays::asList)
                     .collect(Collectors.toList());
    }

    private static void dfs(TreeNode root, String[][] strings, int pos, int end, int level) {
        if (root == null) {
            return;
        }
        final int mid = pos + end >>> 1;
        strings[level][mid] = String.valueOf(root.val);
        dfs(root.left, strings, pos, mid, level + 1);
        dfs(root.right, strings, mid, end, level + 1);
    }

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
