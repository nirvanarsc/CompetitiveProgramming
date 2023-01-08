package leetcode.weekly_contests.weekly_300_399.weekly_325;

public class P_2 {

    public int takeCharacters(String s, int k) {
        final int[] need = { k, k, k };
        final int n = s.length();
        final char[] w = s.toCharArray();
        final int[] preA = new int[n + 1];
        final int[] preB = new int[n + 1];
        final int[] preC = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preA[i] += preA[i - 1];
            preB[i] += preB[i - 1];
            preC[i] += preC[i - 1];
            if (w[i - 1] == 'a') {
                preA[i]++;
            } else if (w[i - 1] == 'b') {
                preB[i]++;
            } else {
                preC[i]++;
            }
        }
        int res = (int) 1e9;
        for (int i = n; i >= 0; i--) {
            if (i < n) {
                if (w[i] == 'a') {
                    need[0]--;
                } else if (w[i] == 'b') {
                    need[1]--;
                } else {
                    need[2]--;
                }
            }
            final int idx = lowerBound(i, need, preA, preB, preC);
            if (ok(need, idx, preA, preB, preC)) {
                res = Math.min(res, idx + n - i);
            }
        }
        return res == (int) 1e9 ? -1 : res;
    }

    private static boolean ok(int[] need, int idx, int[] preA, int[] preB, int[] preC) {
        return preA[idx] >= need[0] && preB[idx] >= need[1] && preC[idx] >= need[2];
    }

    private static int lowerBound(int to, int[] need, int[] preA, int[] preB, int[] preC) {
        int lo = 0;
        int hi = to;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (!ok(need, mid, preA, preB, preC)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
