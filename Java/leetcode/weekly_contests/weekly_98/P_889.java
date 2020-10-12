package leetcode.weekly_contests.weekly_98;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_889 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        final Map<Integer, Integer> map = new HashMap<>();
        final int n = pre.length;
        for (int i = 0; i < n; i++) {
            map.put(post[i], i);
        }
        return build(0, n - 1, 0, n - 1, pre, map);
    }

    private static TreeNode build(int preLeft,
                                  int preRight,
                                  int postLeft,
                                  int postRight,
                                  int[] pre,
                                  Map<Integer, Integer> map) {
        if (preLeft > preRight || postLeft > postRight) {
            return null;
        }
        final TreeNode root = new TreeNode(pre[preLeft]);
        if (preLeft + 1 <= preRight) {
            final int delta = map.get(pre[preLeft + 1]) - postLeft;
            root.left = build(preLeft + 1, preLeft + delta + 1, postLeft, postLeft + delta, pre, map);
            root.right = build(preLeft + delta + 2, preRight, postLeft + delta + 1, postRight - 1, pre, map);
        }
        return root;
    }
}

