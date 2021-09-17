package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class P_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        final int[] f1 = new int[1005];
        final int[] f2 = new int[1005];
        for (int num : nums1) {
            f1[num]++;
        }
        for (int num : nums2) {
            f2[num]++;
        }
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1005; i++) {
            for (int count = 0; count < Math.min(f1[i], f2[i]); count++) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
