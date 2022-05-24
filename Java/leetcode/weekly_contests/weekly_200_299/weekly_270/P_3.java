package leetcode.weekly_contests.weekly_200_299.weekly_270;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ConstantConditions")
public class P_3 {

    private static class Pair {
        int mask;
        TreeNode lca;

        Pair(int mask, TreeNode lca) {
            this.mask = mask;
            this.lca = lca;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        return dfs(root, p, q).lca;
    }

    private static Pair dfs(TreeNode root, int p, int q) {
        if (root == null) {
            return new Pair(0, null);
        }
        final Pair l = dfs(root.left, p, q);
        final Pair r = dfs(root.right, p, q);
        TreeNode lca = null;
        int mask;
        if (l.lca != null) {
            lca = l.lca;
            mask = 3;
        } else if (r.lca != null) {
            lca = r.lca;
            mask = 3;
        } else {
            mask = l.mask | r.mask;
            if (root.val == p) { mask |= 1; }
            if (root.val == q) { mask |= 2; }
            if (mask == 3) {
                lca = root;
            }
        }
        return new Pair(mask, lca);
    }

    static List<Character> curr;
    static List<Character> res;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        curr = new ArrayList<>();
        res = new ArrayList<>();
        final StringBuilder sb = new StringBuilder();
        final TreeNode lca = lowestCommonAncestor(root, startValue, destValue);
        dfs(lca, startValue);
        for (char ignored : res) {
            sb.append('U');
        }
        res.clear();
        dfs(lca, destValue);
        for (char c : res) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static void dfs(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        if (node.val == target) {
            res.addAll(curr);
            return;
        }
        curr.add('L');
        dfs(node.left, target);
        curr.remove(curr.size() - 1);
        curr.add('R');
        dfs(node.right, target);
        curr.remove(curr.size() - 1);
    }
}
