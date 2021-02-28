package leetcode.weekly_contests.weekly_230;

public class P_1775 {

    public int minOperations(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        final int m = nums2.length;
        if (Math.max(n, m) - Math.min(n * 6, m * 6) > 0) {
            return -1;
        }
        final int[] c1 = new int[7];
        final int[] c2 = new int[7];
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums1) {
            c1[num]++;
            sum1 += num;
        }
        for (int num : nums2) {
            c2[num]++;
            sum2 += num;
        }
        int target1 = Math.min(sum1, sum2);
        target1 = Math.max(target1, Math.max(n, m));
        int target2 = Math.max(sum1, sum2);
        target2 = Math.min(target2, Math.min(6 * n, 6 * m));
        int res = (int) 1e9;
        for (int t = target1; t <= target2; t++) {
            final int l = sum1 > t ? f1(c1, sum1, t) : f2(c1, sum1, t);
            final int r = sum2 > t ? f1(c2, sum2, t) : f2(c2, sum2, t);
            res = Math.min(res, l + r);
        }
        return res;
    }

    private static int f1(int[] c1, int sum1, int target) {
        int res = 0;
        for (int i = 6; i >= 2 && sum1 > target; i--) {
            if (c1[i] > 0) {
                final int diff = Math.min((i - 1) * c1[i], sum1 - target);
                sum1 -= diff;
                res += floorDiv(diff, i - 1);
            }
        }
        return res;
    }

    private static int f2(int[] c1, int sum1, int target) {
        int res = 0;
        for (int i = 1; i <= 5 && sum1 < target; i++) {
            if (c1[i] > 0) {
                final int diff = Math.min((6 - i) * c1[i], target - sum1);
                sum1 += diff;
                res += floorDiv(diff, 6 - i);
            }
        }
        return res;
    }

    private static int floorDiv(int a, int b) {
        return (a + b - 1) / b;
    }
}
