package weekly_contests.weekly_4;

import java.util.Arrays;

public class P_396 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int maxRotateFunction(int[] A) {
        final int sum = Arrays.stream(A).sum();
        int f = 0;
        for (int i = 0; i < A.length; i++) {
            f += i * A[i];
        }
        int res = f;
        final int last = A.length - 1;
        for (int i = last; i >= 0; i--) {
            f = f - last * A[i] + (sum - A[i]);
            res = Math.max(res, f);
        }
        return res;
    }
}
