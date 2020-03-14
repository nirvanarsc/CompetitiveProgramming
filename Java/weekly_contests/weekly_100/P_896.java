package weekly_contests.weekly_100;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_896 {

    public boolean isMonotonic(int[] A) {
        return isMonotonic(A, true) || isMonotonic(A, false);
    }

    private static boolean isMonotonic(int[] A, boolean increasing) {
        for (int i = 0; i < A.length - 1; i++) {
            if (increasing ? A[i] > A[i + 1] : A[i] < A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonicLoop(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; i++) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
    }
}
