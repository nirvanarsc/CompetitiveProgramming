package leetcode.weekly_contests.weekly_200_299.weekly_262;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        final int[] f = new int[105];
        process(nums1, f);
        process(nums2, f);
        process(nums3, f);
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < f.length; i++) {
            if (f[i] > 1) {
                res.add(i);
            }
        }
        return res;
    }

    private static void process(int[] nums1, int[] f) {
        final boolean[] seen = new boolean[105];
        for (int num : nums1) {
            if (!seen[num]) {
                f[num]++;
            }
            seen[num] = true;
        }
    }
}
