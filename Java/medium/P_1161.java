package medium;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import utils.DataStructures.TreeNode;

public class P_1161 {

    public int maxLevelSum(TreeNode root) {
        final Deque<TreeNode> queue = new LinkedList<>(Collections.singletonList(root));
        int maxSum = 0, res = 0, level = 0;
        while (!queue.isEmpty()) {
            level++;
            int levelSize = queue.size();
            int levelSum = 0;
            while (levelSize-- > 0) {
                final TreeNode treeNode = queue.removeFirst();
                levelSum += treeNode.val;
                if (treeNode.left != null) {
                    queue.offerLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offerLast(treeNode.right);
                }
            }
            if (maxSum < levelSum) {
                maxSum = levelSum;
                res = level;
            }
        }
        return res;
    }
}
