package leetcode.weekly_contests.weekly_300_399.weekly_315;

import java.util.HashSet;
import java.util.Set;

public class P_2 {

    public int countDistinctIntegers(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            set.add(rev(num));
        }
        return set.size();
    }

    private static int rev(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        return res;
    }
}
