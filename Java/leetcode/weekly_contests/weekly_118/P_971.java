package leetcode.weekly_contests.weekly_118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_971 {

    int i;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        final List<Integer> res = new ArrayList<>();
        return dfs(root, voyage, res) ? res : Collections.singletonList(-1);
    }

    @SuppressWarnings("ConstantConditions")
    private boolean dfs(TreeNode root, int[] voyage, List<Integer> res) {
        if (root == null) { return true; }
        if (root.val != voyage[i++]) { return false; }
        if (root.left != null && root.left.val != voyage[i]) {
            res.add(root.val);
            return dfs(root.right, voyage, res) && dfs(root.left, voyage, res);
        }
        return dfs(root.left, voyage, res) && dfs(root.right, voyage, res);
    }
}
