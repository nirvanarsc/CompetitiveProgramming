package weekly_contests.weekly_180;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_1382 {

    public TreeNode sortedArrayToBST(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        }
        final int mid = start + end >>> 1;
        final TreeNode root = new TreeNode(nums.get(mid));
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }

    private static void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public TreeNode balanceBST(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return sortedArrayToBST(res, 0, res.size() - 1);
    }
}
