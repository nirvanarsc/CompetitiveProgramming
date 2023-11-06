package leetcode.weekly_contests.weekly_300_399.weekly_369;

public class P_2 {

    public long minSum(int[] nums1, int[] nums2) {
        int l = 0;
        int r = 0;
        long ll = 0;
        long rr = 0;
        for (int num : nums1) {
            if (num == 0) {
                l++;
            }
            ll += num;
        }
        for (int num : nums2) {
            if (num == 0) {
                r++;
            }
            rr += num;
        }
        if (l == 0) {
            if (ll < rr + r) {
                return -1;
            }
        }
        if (r == 0) {
            if (rr < ll + l) {
                return -1;
            }
        }
        return Math.max(l + ll, rr + r);
    }
}
