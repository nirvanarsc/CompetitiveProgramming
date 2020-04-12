package weekly_contests.weekly_174;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_1339 {

    private static final int MOD = (int) (1e9 + 7);

    public int maxProductBF(TreeNode root) {
        final List<Integer> sums = new ArrayList<>();
        final long total = dfs(root, sums);
        long res = 0;
        for (long sum : sums) {
            res = Math.max(res, sum * (total - sum));
        }
        return (int) (res % MOD);
    }

    public int dfs(TreeNode node, List<Integer> sums) {
        if (node == null) {
            return 0;
        }
        final int curr = node.val + dfs(node.left, sums) + dfs(node.right, sums);
        sums.add(curr);
        return curr;
    }

    // Modular Arithmetic = No Overflow
    public int maxProduct(TreeNode root) {
        final List<Integer> sums = new ArrayList<>();
        final int total = dfs(root, sums);
        int nearestToHalf = 0;
        int smallestDistanceBetween = Integer.MAX_VALUE;
        for (int sum : sums) {
            final int diff = Math.abs(total - sum * 2);
            if (diff < smallestDistanceBetween) {
                smallestDistanceBetween = diff;
                nearestToHalf = sum;
            }
        }
        return modularMultiplication(nearestToHalf, total - nearestToHalf, MOD);
    }

    private static int modularMultiplication(int a, int b, int mod) {
        int product = 0;
        int currentSum = a;
        while (b > 0) {
            final int bit = b % 2;
            b >>= 1;
            if (bit == 1) {
                product += currentSum;
                product %= mod;
            }
            currentSum <<= 1;
            currentSum %= mod;
        }
        return product;
    }
}
