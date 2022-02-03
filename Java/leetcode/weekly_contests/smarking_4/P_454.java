package leetcode.weekly_contests.smarking_4;

import java.util.HashMap;
import java.util.Map;

public class P_454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int ll : nums1) {
            for (int rr : nums2) {
                map.merge(ll + rr, 1, Integer::sum);
            }
        }
        for (int ll : nums3) {
            for (int rr : nums4) {
                res += map.getOrDefault(-(ll + rr), 0);
            }
        }
        return res;
    }
}
