package leetcode.weekly_contests.weekly_300_399.weekly_379;

import java.util.HashSet;
import java.util.Set;

public class P_3 {

    public int maximumSetSize(int[] nums1, int[] nums2) {
        final Set<Integer> l = new HashSet<>();
        final Set<Integer> r = new HashSet<>();
        final Set<Integer> all = new HashSet<>();
        final int n = nums1.length / 2;
        for (int num : nums1) {
            l.add(num);
            all.add(num);
        }
        for (int num : nums2) {
            r.add(num);
            all.add(num);
        }
        return Math.min(Math.min(n, l.size()) + Math.min(n, r.size()), all.size());
    }
}
