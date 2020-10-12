package leetcode.weekly_contests.weekly_81;

public class P_821 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] shortestToChar(String S, char C) {
        final int n = S.length();
        final int[] arr = new int[n];
        int lastC = n;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) {
                lastC = 0;
            }
            arr[i] = lastC++;
        }
        lastC = n;
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                lastC = 0;
            }
            arr[i] = Math.min(lastC++, arr[i]);
        }
        return arr;
    }
}
