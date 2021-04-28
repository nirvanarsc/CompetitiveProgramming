package binarysearch.weekly_47;

public class P_4 {

    public int solve(int[] nums) {
        final int n = nums.length;
        final int[] l = f(nums, n);
        final int[] r = reverse(f(reverse(nums, n), n), n);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, l[i] + r[i] - nums[i]);
        }
        return res;
    }

    private static int[] f(int[] nums, int n) {
        final int[] stackV = new int[n];
        final int[] stackC = new int[n];
        int sum = 0;
        int idx = 0;
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (idx > 0 && stackV[idx - 1] > nums[i]) {
                count += stackC[--idx];
                sum -= stackC[idx] * stackV[idx];
            }
            stackV[idx] = nums[i];
            stackC[idx++] = count;
            sum += count * nums[i];
            res[i] = sum;
        }
        return res;
    }

    private static int[] reverse(int[] nums, int n) {
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[n - 1 - i] = nums[i];
        }
        return res;
    }
}
