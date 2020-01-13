package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_652 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        final List<TreeNode> res = new ArrayList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) {
            return "#";
        }
        final String serial = cur.val + postorder(cur.left, map, res) + postorder(cur.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) {
            res.add(cur);
        }
        map.merge(serial, 1, Integer::sum);
        return serial;
    }
}
