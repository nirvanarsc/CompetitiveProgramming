package binarysearch.weekly_36;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_3 {

    private static class Tree {
        int val;
        Tree left;
        Tree right;
    }

    public Tree solve(Tree root) {
        if (root == null) {
            return null;
        }
        final Deque<Tree> dq = new ArrayDeque<>();
        dq.offerLast(root);
        final List<List<Tree>> levels = new ArrayList<>();
        while (!dq.isEmpty()) {
            final List<Tree> curr = new ArrayList<>();
            for (int size = dq.size(); size > 0; size--) {
                final Tree pop = dq.removeFirst();
                if (pop.left != null) {
                    dq.offerLast(pop.left);
                }
                if (pop.right != null) {
                    dq.offerLast(pop.right);
                }
                curr.add(pop);
            }
            levels.add(curr);
        }
        for (int i = levels.size() - 1; i >= 0; i--) {
            final List<Tree> children = new ArrayList<>();
            for (Tree t : levels.get(i)) {
                if (t.left != null) {
                    children.add(t.left);
                    t.left = null;
                }
                if (t.right != null) {
                    children.add(t.right);
                    t.right = null;
                }
            }
            int idx = children.size() - 1;
            for (int j = levels.get(i).size() - 1; j >= 0 && idx >= 0; j--) {
                levels.get(i).get(j).right = children.get(idx--);
                if (idx == -1) {
                    break;
                }
                levels.get(i).get(j).left = children.get(idx--);
            }
        }
        return root;
    }
}
