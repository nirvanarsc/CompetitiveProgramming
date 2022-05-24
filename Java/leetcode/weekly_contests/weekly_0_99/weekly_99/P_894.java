package leetcode.weekly_contests.weekly_0_99.weekly_99;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_894 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public List<TreeNode> allPossibleFBT(int N) {
        final List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        N -= 1;
        for (int i = 1; i < N; i += 2) {
            final List<TreeNode> left = allPossibleFBT(i);
            final List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode nl : left) {
                for (TreeNode nr : right) {
                    final TreeNode cur = new TreeNode(0);
                    cur.left = nl;
                    cur.right = nr;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
