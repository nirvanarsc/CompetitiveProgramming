package weekly_contests.weekly_87;

public class P_845 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int longestMountain(int[] A) {
        int maxMnt = 0, i = 1;
        while (i < A.length) {
            while (i < A.length && A[i - 1] == A[i]) {
                ++i;
            }
            int up = 0;
            while (i < A.length && A[i - 1] < A[i]) {
                ++up;
                ++i;
            }
            int down = 0;
            while (i < A.length && A[i - 1] > A[i]) {
                ++down;
                ++i;
            }
            if (up > 0 && down > 0) {
                maxMnt = Math.max(maxMnt, up + down + 1);
            }
        }
        return maxMnt;
    }
}
