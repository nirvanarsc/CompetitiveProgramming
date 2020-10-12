package leetcode.weekly_contests.weekly_23;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_536 {

    public TreeNode str2tree(String s) {
        return recurse(s, 0, s.length() - 1);
    }

    private static TreeNode recurse(String s, int i, int j) {
        if (i > j) {
            return null;
        }
        int t = s.charAt(i) == '-' ? i + 1 : i;
        while (t <= j && Character.isDigit(s.charAt(t))) {
            t++;
        }
        final TreeNode root = new TreeNode(Integer.parseInt(s.substring(i, t)));
        int open = 0;
        int closeIdx = -1;
        for (int k = t; k <= j; k++) {
            open += s.charAt(k) == '(' ? 1 : 0;
            open -= s.charAt(k) == ')' ? 1 : 0;
            if (open == 0) {
                closeIdx = k;
                break;
            }
        }
        if (closeIdx != -1) {
            root.left = recurse(s, t + 1, closeIdx - 1);
            root.right = recurse(s, closeIdx + 2, j - 1);
        }
        return root;
    }
}
