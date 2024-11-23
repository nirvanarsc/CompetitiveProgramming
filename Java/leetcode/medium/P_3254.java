package leetcode.medium;

public class P_3254 {

    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        final int n = nums.length;
        final int[] res = new int[n - k + 1];
        final int[] d = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            d[i] = nums[i + 1] - nums[i] == 1 ? 1 : 0;
        }
        int curr = 0;
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            curr += d[i];
            if (i >= k - 2) {
                res[idx++] = curr == k - 1 ? nums[i + 1] : -1;
                curr -= d[i - k + 2];
            }
        }
        return res;
    }
}
