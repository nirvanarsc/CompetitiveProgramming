package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_894 {

    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int nodes) {
        if (memo.containsKey(nodes)) {
            return memo.get(nodes);
        }
        final List<TreeNode> res = new ArrayList<>();
        if (nodes == 0) {
            return res;
        }
        if (nodes == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        for (int i = 1; i < nodes; i += 2) {
            final List<TreeNode> left = allPossibleFBT(i);
            final List<TreeNode> right = allPossibleFBT(nodes - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    final TreeNode curr = new TreeNode(0);
                    curr.left = l;
                    curr.right = r;
                    res.add(curr);
                }
            }
        }
        memo.put(nodes, res);
        return res;
    }
}
