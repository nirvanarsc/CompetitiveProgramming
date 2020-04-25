package weekly_contests.weekly_42;

import java.util.HashSet;
import java.util.Set;

public class P_645 {

    public int[] findErrorNums(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        int dup = -1;
        int sum = 0;
        for (int num : nums) {
            if (!set.add(num)) {
                dup = num;
            } else {
                sum += num;
            }
        }
        final int miss = nums.length * (nums.length + 1) / 2 - sum;
        return new int[] { dup, miss };
    }
}
