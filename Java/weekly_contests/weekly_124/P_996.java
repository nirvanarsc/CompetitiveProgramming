package weekly_contests.weekly_124;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_996 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        final List<Integer> list = new ArrayList<>();
        for (int num : A) { list.add(num); }
        final int[] ans = { 0 };
        recurse(list, 0, ans);
        return ans[0];
    }

    private static void recurse(List<Integer> list, int idx, int[] ans) {
        if (idx >= list.size()) {
            ans[0]++;
            return;
        }
        final Set<Integer> set = new HashSet<>();
        for (int i = idx; i < list.size(); i++) {
            if ((idx == 0 || isSquare(list.get(idx - 1) + list.get(i))) && set.add(list.get(i))) {
                Collections.swap(list, idx, i);
                recurse(list, idx + 1, ans);
                Collections.swap(list, idx, i);
            }
        }
    }

    private static boolean isSquare(int v) {
        final int r = (int) Math.sqrt(v);
        return r * r == v;
    }
}
