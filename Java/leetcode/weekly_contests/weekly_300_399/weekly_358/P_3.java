package leetcode.weekly_contests.weekly_300_399.weekly_358;

import java.util.List;
import java.util.TreeMap;

public class P_3 {

    public int minAbsoluteDifference(List<Integer> nums, int x) {
        final TreeMap<Integer, Integer> r = new TreeMap<>();
        final TreeMap<Integer, Integer> l = new TreeMap<>();
        final int n = nums.size();
        int res = (int) 1e9;
        for (int i = x; i < n; i++) {
            r.merge(nums.get(i), 1, Integer::sum);
        }
        for (int i = 0; i < n; i++) {
            res = f(res, nums.get(i), l.ceilingKey(nums.get(i)));
            res = f(res, nums.get(i), l.floorKey(nums.get(i)));
            res = f(res, nums.get(i), r.ceilingKey(nums.get(i)));
            res = f(res, nums.get(i), r.floorKey(nums.get(i)));
            if (i + x < n) {
                if (r.merge(nums.get(i + x), -1, Integer::sum) == 0) {
                    r.remove(nums.get(i + x));
                }
            }
            if (i >= x) {
                l.merge(nums.get(i - x), 1, Integer::sum);
            }
        }
        return res;
    }

    private static int f(int res, int num, Integer closest) {
        if (closest == null) {
            return res;
        }
        return Math.min(res, Math.abs(num - closest));
    }
}
