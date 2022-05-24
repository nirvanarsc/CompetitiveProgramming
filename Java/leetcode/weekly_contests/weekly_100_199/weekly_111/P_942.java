package leetcode.weekly_contests.weekly_100_199.weekly_111;

public class P_942 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] diStringMatch(String S) {
        final int n = S.length();
        int D = n, I = 0;
        final int[] res = new int[n + 1];
        for (int j = 0; j < S.length(); j++) {
            res[j] = S.charAt(j) == 'D' ? D-- : I++;
        }
        res[n] = D;
        return res;
    }
}
