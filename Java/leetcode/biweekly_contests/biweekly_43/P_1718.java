package leetcode.biweekly_contests.biweekly_43;

@SuppressWarnings({ "TailRecursion", "ReturnOfNull" })
public class P_1718 {

    public int[] constructDistancedSequence(int n) {
        return dfs(new int[2 * n - 1], n, 0, 0);
    }

    private static int[] dfs(int[] arr, int n, int idx, int mask) {
        if (idx == arr.length) {
            return arr;
        }
        if (arr[idx] == 0) {
            for (int k = n; k >= 1; k--) {
                if ((mask & (1 << k)) == 0) {
                    if (k == 1) {
                        arr[idx] = 1;
                        final int[] dfs = dfs(arr, n, idx + 1, mask | (1 << 1));
                        if (dfs != null) {
                            return dfs;
                        }
                        arr[idx] = 0;
                    } else {
                        if (idx + k < arr.length && arr[idx + k] == 0) {
                            arr[idx] = k;
                            arr[idx + k] = k;
                            final int[] dfs = dfs(arr, n, idx + 1, mask | (1 << k));
                            if (dfs != null) {
                                return dfs;
                            }
                            arr[idx] = 0;
                            arr[idx + k] = 0;
                        }
                    }
                }
            }
            return null;
        }
        return dfs(arr, n, idx + 1, mask);
    }
}
