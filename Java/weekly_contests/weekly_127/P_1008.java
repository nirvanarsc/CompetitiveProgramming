package weekly_contests.weekly_127;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ConstantConditions")
public class P_1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        return recurse(preorder, 0, preorder.length - 1);
    }

    private static TreeNode recurse(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        final TreeNode node = new TreeNode(preorder[start]);
        int newEnd = start + 1;
        while (newEnd <= end && preorder[newEnd] < preorder[start]) {
            newEnd++;
        }

        node.left = recurse(preorder, start + 1, newEnd - 1);
        node.right = recurse(preorder, newEnd, end);
        return node;
    }
}
