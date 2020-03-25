package weekly_contests.weekly_83;

public class P_828 {

    private static final int MOD = (int) (1e9 + 7);

    @SuppressWarnings("MethodParameterNamingConvention")
    public int uniqueLetterString(String S) {
        final char[] s = S.toCharArray();
        final int n = s.length;
        long res = 0;
        for (int i = 0; i < s.length; i++) {
            int l = i - 1;
            while (l >= 0 && s[l] != s[i]) {
                l--;
            }
            int r = i + 1;
            while (r < n && s[r] != s[i]) {
                r++;
            }
            res += (long) (r - i) * (i - l);
        }
        return (int) (res % MOD);
    }
}
