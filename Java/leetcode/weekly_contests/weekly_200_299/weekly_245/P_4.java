package leetcode.weekly_contests.weekly_200_299.weekly_245;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P_4 {

    static int min;
    static int max;

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        min = 300;
        max = 0;
        dfs(1, IntStream.range(1, n + 1).toArray(), firstPlayer, secondPlayer);
        return new int[] { min, max };
    }

    private static void dfs(int round, int[] ints, int l, int r) {
        int size = 0;
        for (int i = 0, j = ints.length - 1; i < j; i++, j--) {
            if (ints[i] == l && ints[j] == r || ints[i] == r && ints[j] == l) {
                min = Math.min(min, round);
                max = Math.max(max, round);
                return;
            }
            if (ints[i] != l && ints[i] != r && ints[j] != l && ints[j] != r) {
                size++;
            }
        }
        for (int mask = 0; mask < (1 << size); mask++) {
            final int[] next = new int[(ints.length + 1) / 2];
            if (ints.length % 2 != 0) {
                next[next.length - 1] = ints[ints.length / 2];
            }
            int idx = 0;
            for (int i = 0, j = ints.length - 1; i < j; i++, j--) {
                if (ints[i] != l && ints[i] != r && ints[j] != l && ints[j] != r) {
                    if ((mask & (1 << idx)) != 0) {
                        next[i] = ints[i];
                    } else {
                        next[i] = ints[j];
                    }
                    idx++;
                } else if (ints[i] == l) {
                    next[i] = l;
                } else if (ints[i] == r) {
                    next[i] = r;
                } else if (ints[j] == l) {
                    next[i] = l;
                } else if (ints[j] == r) {
                    next[i] = r;
                }
            }
            Arrays.sort(next);
            dfs(round + 1, next, l, r);
        }
    }
}
