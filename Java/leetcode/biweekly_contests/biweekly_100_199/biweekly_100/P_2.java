package leetcode.biweekly_contests.biweekly_100_199.biweekly_100;

import java.util.Arrays;
import java.util.TreeMap;

public class P_2 {

    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int num : nums) {
            tm.merge(num, 1, Integer::sum);
        }
        int res = 0;
        for (int num : nums) {
            final Integer u = tm.higherKey(num);
            if (u == null) {
                break;
            }
            res++;
            if (tm.merge(u, -1, Integer::sum) == 0) {
                tm.remove(u);
            }
        }
        return res;
    }
}
