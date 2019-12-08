import java.util.Deque;
import java.util.LinkedList;

import utils.DataStructures.TreeNode;

public class BSTtoGreaterSumTree {

    public TreeNode bstToGst(TreeNode root) {
        final Deque<TreeNode> list = inOrder(root, new LinkedList<>());
        int sum = 0;
        for (TreeNode node : list) {
            node.val += sum;
            sum += node.val;
        }

        return root;
    }

    private static Deque<TreeNode> inOrder(TreeNode root, Deque<TreeNode> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.addFirst(root);
            inOrder(root.right, list);
        }
        return list;
    }
}
