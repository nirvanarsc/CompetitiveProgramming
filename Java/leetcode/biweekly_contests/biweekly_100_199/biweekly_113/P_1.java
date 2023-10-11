package leetcode.biweekly_contests.biweekly_100_199.biweekly_113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_1 {

    public int minimumRightShifts(List<Integer> nums) {
        final List<Integer> sorted = new ArrayList<>(nums);
        sorted.sort(Comparator.naturalOrder());
        int j = nums.indexOf(sorted.get(0));
        final int n = nums.size();
        for (int i = 0; i < n; i++, j = (j + 1) % n) {
            if (!nums.get(j).equals(sorted.get(i))) {
                return -1;
            }
        }
        return (n - j) % n;
    }
}
