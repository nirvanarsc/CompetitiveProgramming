package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_350 {

    @SuppressWarnings("TailRecursion")
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums1) {
            freq.merge(num, 1, Integer::sum);
        }
        int idx = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (freq.containsKey(nums2[i])) {
                if (freq.merge(nums2[i], -1, Integer::sum) == 0) {
                    freq.remove(nums2[i]);
                }
                nums2[idx] = nums2[i];
                idx++;
            }
        }
        return Arrays.copyOfRange(nums2, 0, idx);
    }
}
