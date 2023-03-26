package leetcode.weekly_contests.weekly_300_399.weekly_338;

public class P_1 {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        final int[] arr = { numOnes, numZeros, numNegOnes };
        final int[] v = { 1, 0, -1 };
        int res = 0;
        for (int i = 0; i < 3 && k > 0; i++) {
            res += Math.min(k, arr[i]) * v[i];
            k -= Math.min(k, arr[i]);
        }
        return res;
    }
}
