package weekly_contests.smarking_1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_437 {

    public int pathSum(TreeNode root, int sum) {
        return helper(root, 0, sum, new HashMap<>(Collections.singletonMap(0, 1)));
    }

    public int helper(TreeNode root, int currSum, int target, Map<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.merge(currSum, 1, Integer::sum);
        res += helper(root.left, currSum, target, preSum);
        res += helper(root.right, currSum, target, preSum);
        preSum.merge(currSum, -1, Integer::sum);
        return res;
    }

    public int pathSumBF(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int dfs(TreeNode root, int sum, int curr) {
        if (root == null) {
            return 0;
        }
        return (curr + root.val == sum ? 1 : 0)
               + dfs(root.left, sum, curr + root.val)
               + dfs(root.right, sum, curr + root.val);
    }
}
