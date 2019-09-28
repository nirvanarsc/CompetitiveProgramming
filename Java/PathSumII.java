import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode node, int remainingSum, List<Integer> path) {
        if (node == null) {
            return;
        }
        final int val = remainingSum - node.val;
        path.add(node.val);

        if (node.left == node.right && val == 0) {
            res.add(new ArrayList<>(path));
        } else {
            dfs(node.right, val, path);
            dfs(node.left, val, path);
        }

        path.remove(path.size() - 1);
    }
}
