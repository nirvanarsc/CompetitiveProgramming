package weekly_contests.weekly_69;

public class P_775 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public boolean isIdealPermutation(int[] A) {
        int global = 0;
        int local = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    global++;
                }
            }
            if (i < A.length - 1 && A[i] > A[i + 1]) {
                local++;
            }
        }
        return global == local;
    }
}
