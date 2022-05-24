package leetcode.weekly_contests.weekly_100_199.weekly_116;

import java.util.HashSet;
import java.util.Set;

public class P_961 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int repeatedNTimes(int[] A) {
        final Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
