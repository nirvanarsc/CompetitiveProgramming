package leetcode.easy;

public class P_985 {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        final int n = queries.length;
        final int[] res = new int[n];
        int sum = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                sum += num;
            }
        }
        for (int i = 0; i < n; i++) {
            final int[] q = queries[i];
            if ((nums[q[1]] & 1) == 0) {
                sum -= nums[q[1]];
            }
            nums[q[1]] += q[0];
            if ((nums[q[1]] & 1) == 0) {
                sum += nums[q[1]];
            }
            res[i] = sum;
        }
        return res;
    }
}
