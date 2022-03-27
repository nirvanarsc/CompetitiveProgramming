package leetcode.weekly_contests.weekly_286;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        final boolean[] l = new boolean[2005];
        final boolean[] r = new boolean[2005];
        for (int num : nums1) {
            l[1000 + num] = true;
        }
        for (int num : nums2) {
            r[1000 + num] = true;
        }
        final List<Integer> ll = new ArrayList<>();
        final List<Integer> rr = new ArrayList<>();
        for (int i = 0; i < 2005; i++) {
            if (l[i] && !r[i]) {
                ll.add(i - 1000);
            }
            if (!l[i] && r[i]) {
                rr.add(i - 1000);
            }
        }
        return Arrays.asList(ll, rr);
    }
}
