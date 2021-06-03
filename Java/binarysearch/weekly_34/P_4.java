package binarysearch.weekly_34;

public class P_4 {

    public int solve(int[] nums, int pos) {
        final int n = nums.length;
        int curr = nums[pos];
        int res = nums[pos];
        int l = pos;
        int r = pos;
        while (r - l + 1 != n) {
            if (l == 0) {
                curr = Math.min(curr, nums[++r]);
                res = Math.max(res, curr * (r + 1));
            } else if (r == n - 1) {
                curr = Math.min(curr, nums[--l]);
                res = Math.max(res, curr * (r - l + 1));
            } else {
                if (nums[l - 1] > nums[r + 1]) {
                    curr = Math.min(curr, nums[--l]);
                } else {
                    curr = Math.min(curr, nums[++r]);
                }
                res = Math.max(res, curr * (r - l + 1));
            }
        }
        return res;
    }
}
