package weekly_contests.weekly_111;

public class P_941 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public boolean validMountainArray(int[] A) {
        int start = 0, end = A.length - 1;
        while (start < end) {
            if (A[start] < A[start + 1]) {
                start++;
            } else if (A[end - 1] > A[end]) {
                end--;
            } else {
                break;
            }
        }
        return start > 0 && end < A.length - 1 && start == end;
    }
}
