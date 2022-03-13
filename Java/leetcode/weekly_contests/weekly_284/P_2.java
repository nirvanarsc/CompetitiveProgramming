package leetcode.weekly_contests.weekly_284;

import java.util.HashSet;
import java.util.Set;

public class P_2 {

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        final Set<Integer> set = new HashSet<>();
        for (int[] d : dig) {
            set.add(d[0] * n + d[1]);
        }
        int res = 0;
        for (int[] a : artifacts) {
            boolean ok = true;
            outer:
            for (int i = a[0]; i <= a[2]; i++) {
                for (int j = a[1]; j <= a[3]; j++) {
                    if (!set.contains(i * n + j)) {
                        ok = false;
                        break outer;
                    }
                }
            }
            if (ok) {
                res++;
            }
        }
        return res;
    }
}
