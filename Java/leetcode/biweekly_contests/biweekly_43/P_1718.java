package leetcode.biweekly_contests.biweekly_43;

@SuppressWarnings({ "TailRecursion", "ReturnOfNull" })
public class P_1718 {

    public int[] constructDistancedSequence(int n) {
        final int[] curr = new int[2 * n - 1];
        return dfs(curr, 0, 0, n);
    }

    private static int[] dfs(int[] curr, int idx, int mask, int n) {
        if (idx == curr.length) {
            return curr;
        }
        if (curr[idx] != 0) {
            return dfs(curr, idx + 1, mask, n);
        }
        for (int i = n - 1; i >= 0; i--) {
            if ((mask & (1 << i)) == 0) {
                if (i == 0) {
                    curr[idx] = 1;
                    final int[] dfs = dfs(curr, idx + 1, mask | 1, n);
                    if (dfs != null) {
                        return dfs;
                    }
                    curr[idx] = 0;
                } else {
                    if ((idx + i + 1) < curr.length && curr[idx + i + 1] == 0) {
                        curr[idx] = curr[idx + i + 1] = i + 1;
                        final int[] dfs = dfs(curr, idx + 1, mask | (1 << i), n);
                        if (dfs != null) {
                            return dfs;
                        }
                        curr[idx] = curr[idx + i + 1] = 0;
                    }
                }
            }
        }
        return null;
    }
}
