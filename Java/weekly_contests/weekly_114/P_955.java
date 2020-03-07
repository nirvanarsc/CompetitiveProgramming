package weekly_contests.weekly_114;

import java.util.HashSet;
import java.util.Set;

public class P_955 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int minDeletionSize(String[] A) {
        final Set<Integer> set = new HashSet<>();
        for (int i = 1; i < A.length; ++i) {
            for (int j = 0; j < A[i].length(); ++j) {
                if (set.contains(j) || A[i - 1].charAt(j) == A[i].charAt(j)) {
                    continue;
                }
                if (A[i - 1].charAt(j) > A[i].charAt(j)) {
                    set.add(j);
                    i = 0;
                }
                break;
            }
        }
        return set.size();
    }
}
