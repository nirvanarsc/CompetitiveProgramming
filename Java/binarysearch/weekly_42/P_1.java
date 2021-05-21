package binarysearch.weekly_42;

public class P_1 {

    public static class Tree {
        Tree left, right;
    }

    public boolean solve(Tree root, int target) {
        int n = 0;
        for (int i = Integer.SIZE - 1; i >= 0; i--) {
            if ((target & (1 << i)) != 0) {
                n = i;
                break;
            }
        }
        return target > 0 && dfs(root, target, n - 1);
    }

    private static boolean dfs(Tree node, int target, int idx) {
        if (idx == -1) {
            return node != null;
        }
        if (node == null) {
            return false;
        }
        return ((target & (1 << idx)) != 0) ? dfs(node.right, target, idx - 1)
                                            : dfs(node.left, target, idx - 1);
    }
}
