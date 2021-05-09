package leetcode.weekly_contests.weekly_240;

import java.util.Map;
import java.util.TreeMap;

public class P_1855 {

    public int maxDistance(int[] nums1, int[] nums2) {
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < nums2.length; i++) {
            tm.put(nums2[i], i);
        }
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            final Map.Entry<Integer, Integer> entry = tm.ceilingEntry(nums1[i]);
            if (entry != null) {
                final int curr = entry.getValue() - i;
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
