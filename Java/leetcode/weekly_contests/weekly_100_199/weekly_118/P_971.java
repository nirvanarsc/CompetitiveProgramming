package leetcode.weekly_contests.weekly_100_199.weekly_118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_971 {

    int idx;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        final List<Integer> res = new ArrayList<>();
        return dfs(root, voyage, res) ? res : Collections.singletonList(-1);
    }

    private boolean dfs(TreeNode root, int[] voyage, List<Integer> res) {
        if (root == null) {
            return true;
        }
        final int val = voyage[idx];
        if (root.val != val) {
            return false;
        }
        idx++;
        if (dfs(root.left, voyage, res) && dfs(root.right, voyage, res)) {
            return true;
        }
        res.add(val);
        return dfs(root.right, voyage, res) && dfs(root.left, voyage, res);
    }
}
