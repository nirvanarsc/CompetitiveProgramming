package leetcode.weekly_contests.weekly_100_199.weekly_100;

import java.util.HashSet;
import java.util.Set;

public class P_898 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int subarrayBitwiseORs(int[] A) {
        final Set<Integer> res = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        for (int num : A) {
            final Set<Integer> curr = new HashSet<>();
            curr.add(num);
            for (int p : prev) {
                curr.add(p | num);
            }
            prev = curr;
            res.addAll(prev);
        }
        return res.size();
    }
}
