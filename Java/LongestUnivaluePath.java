public class LongestUnivaluePath {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) { return 0; }
        return go(root, new int[] { 0, 0 })[1];
    }

    private static int[] go(TreeNode root, int[] res) {
        int l = root.left != null ? go(root.left, res)[0] : 0;
        int r = root.right != null ? go(root.right, res)[0] : 0;
        l = (root.left != null && root.left.val == root.val) ? l + 1 : 0;
        r = (root.right != null && root.right.val == root.val) ? r + 1 : 0;
        res[1] = Math.max(res[1], l + r);
        res[0] = Math.max(l, r);
        return res;
    }
}
