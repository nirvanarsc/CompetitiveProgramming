package leetcode.weekly_contests.weekly_105;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_919 {

    class CBTInserter {
        int currP;
        int idx;
        List<TreeNode> arr = new ArrayList<>();

        CBTInserter(TreeNode root) {
            final Deque<TreeNode> q = new ArrayDeque<>(Collections.singleton(root));
            while (!q.isEmpty()) {
                for (int size = q.size(); size > 0; size--) {
                    final TreeNode curr = q.removeFirst();
                    arr.add(curr);
                    idx++;
                    if (curr.left != null) { q.offerLast(curr.left); }
                    if (curr.right != null) { q.offerLast(curr.right); }
                }
            }
            currP = idx / 2 - (idx % 2 == 0 ? 1 : 0);
        }

        public int insert(int v) {
            final boolean left = idx % 2 != 0;
            final TreeNode newNode = new TreeNode(v);
            final int res = arr.get(currP).val;
            if (left) {
                arr.get(currP).left = newNode;
            } else {
                arr.get(currP).right = newNode;
                currP++;
            }
            arr.add(newNode);
            idx++;
            return res;
        }

        public TreeNode get_root() {
            return arr.get(0);
        }
    }
}


