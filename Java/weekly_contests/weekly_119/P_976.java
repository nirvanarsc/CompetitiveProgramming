package weekly_contests.weekly_119;

import java.util.Arrays;

public class P_976 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i - 1] + A[i - 2] > A[i]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}
