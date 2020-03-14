package weekly_contests.weekly_100;

import java.util.HashSet;
import java.util.Set;

public class P_898 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int subarrayBitwiseORs(int[] A) {
        final Set<Integer> set = new HashSet<>();
        Set<Integer> pre = new HashSet<>();
        for (int i : A) {
            final Set<Integer> cur = new HashSet<>();
            cur.add(i);
            set.add(i);
            for (int p : pre) {
                cur.add(p | i);
                set.add(p | i);
            }
            pre = cur;
        }
        return set.size();
    }
}
