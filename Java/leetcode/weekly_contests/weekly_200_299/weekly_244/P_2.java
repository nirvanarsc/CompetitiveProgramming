package leetcode.weekly_contests.weekly_200_299.weekly_244;

import java.util.TreeMap;

public class P_2 {

    public int reductionOperations(int[] nums) {
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        int curr = nums.length;
        for (int num : nums) {
            tm.merge(num, 1, Integer::sum);
        }
        int res = 0;
        curr -= tm.pollFirstEntry().getValue();
        while (!tm.isEmpty()) {
            res += curr;
            curr -= tm.pollFirstEntry().getValue();
        }
        return res;
    }
}
