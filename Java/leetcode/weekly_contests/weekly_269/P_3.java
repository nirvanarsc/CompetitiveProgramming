package leetcode.weekly_contests.weekly_269;

public class P_3 {

    public int minimumDeletions(int[] nums) {
        final int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int minIdx = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[minIdx] < nums[i]) {
                minIdx = i;
            }
            if (nums[maxIdx] > nums[i]) {
                maxIdx = i;
            }
        }
        int res = (int) 1e9;
        res = Math.min(res, Math.max(minIdx, maxIdx) + 1);
        res = Math.min(res, n - Math.min(minIdx, maxIdx));
        res = Math.min(res, minIdx + 1 + n - maxIdx);
        res = Math.min(res, maxIdx + 1 + n - minIdx);
        return res;
    }
}
