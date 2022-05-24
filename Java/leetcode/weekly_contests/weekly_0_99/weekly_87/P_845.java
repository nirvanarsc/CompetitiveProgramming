package leetcode.weekly_contests.weekly_0_99.weekly_87;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_845 {

    public int longestMountain(int[] A) {
        final int n = A.length;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                int start = i - 1;
                int end = i + 1;
                while (start >= 0 && A[start] < A[start + 1]) { start--; }
                while (end < n && A[end - 1] > A[end]) { end++; }
                res = Math.max(res, end - start - 1);
            }
        }
        return res;
    }
}
