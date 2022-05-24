package leetcode.weekly_contests.weekly_200_299.weekly_228;

public class P_1760 {

    public int minimumSize(int[] nums, int maxOperations) {
        int lo = 1;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            int curr = 0;
            for (int num : nums) {
                if (num > mid) {
                    curr += (num - 1) / mid;
                    // Same as below -> ceil (a/b) => (a + b - 1) / b
                    // curr += (num - mid) / mid + ((num - mid) % mid != 0 ? 1 : 0);
                }
            }
            if (curr > maxOperations) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
