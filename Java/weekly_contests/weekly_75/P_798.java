package weekly_contests.weekly_75;

public class P_798 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int bestRotation(int[] A) {
        final int n = A.length;
        final int[] intervals = new int[n];
        for (int i = 0; i < A.length; i++) {
            intervals[(i + 1) % n]++;
            intervals[(i + 1 - A[i] + n) % n]--;
        }
        int count = 0;
        int maxCount = -1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            count += intervals[i];
            if (count > maxCount) {
                maxCount = count;
                res = i;
            }
        }
        return res;
    }
}
