package leetcode.weekly_contests.weekly_216;

public class P_1664 {

    public int waysToMakeFair(int[] nums) {
        final int n = nums.length;
        final int[] evenSum = new int[n];
        final int[] oddSum = new int[n];
        int currEven = 0;
        int currOdd = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                currEven += nums[i];
            } else {
                currOdd += nums[i];
            }
            evenSum[i] = currEven;
            oddSum[i] = currOdd;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int e = 0;
            int o = 0;
            if (i > 0) {
                e += evenSum[i - 1];
                o += oddSum[i - 1];
            }
            e += oddSum[n - 1] - oddSum[i];
            o += evenSum[n - 1] - evenSum[i];
            if (e == o) {
                res += 1;
            }
        }
        return res;
    }
}
