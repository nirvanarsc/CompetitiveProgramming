package leetcode.weekly_contests.weekly_212;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_1630 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        final List<Boolean> res = new ArrayList<>();
        final int m = l.length;
        for (int i = 0; i < m; i++) {
            final List<Integer> curr = new ArrayList<>();
            for (int j = l[i]; j <= r[i]; j++) {
                curr.add(nums[j]);
            }
            curr.sort(Comparator.naturalOrder());
            boolean isA = true;
            final int diff = curr.get(1) - curr.get(0);
            for (int j = 1; j < curr.size(); j++) {
                if (curr.get(j) - curr.get(j - 1) != diff) {
                    isA = false;
                    break;
                }
            }
            res.add(isA);
        }
        return res;
    }
}
