package leetcode.weekly_contests.weekly_200_299.weekly_296;

import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public int[] arrayChange(int[] nums, int[][] operations) {
        final Map<Integer, Integer> map = new HashMap<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int[] op : operations) {
            final int idx = map.remove(op[0]);
            map.put(op[1], idx);
        }
        final int[] res = new int[n];
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            res[e.getValue()] = e.getKey();
        }
        return res;
    }
}
