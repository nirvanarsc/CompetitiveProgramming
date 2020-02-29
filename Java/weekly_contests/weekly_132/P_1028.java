package weekly_contests.weekly_132;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class P_1028 {

    public TreeNode recoverFromPreorder(String S) {
        int level, val, i = 0;
        final Deque<TreeNode> stack = new ArrayDeque<>();
        while (i < S.length()) {
            for (level = 0; S.charAt(i) == '-'; i++) {
                level++;
            }
            for (val = 0; i < S.length() && S.charAt(i) != '-'; i++) {
                val = val * 10 + (S.charAt(i) - '0');
            }
            while (stack.size() > level) {
                stack.removeFirst();
            }
            final TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.addFirst(node);
        }
        return stack.removeLast();
    }
}
