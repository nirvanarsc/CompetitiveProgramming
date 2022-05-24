package leetcode.weekly_contests.weekly_100_199.weekly_102;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_906 {

    public int superpalindromesInRange(String L, String R) {
        final long l = Long.parseLong(L);
        final long r = Long.parseLong(R);
        return f(r) - f(l - 1);
    }

    private static int f(long n) {
        final int[] res = { 0 };
        dfs("", n, res);
        return res[0];
    }

    private static void dfs(String s, long r, int[] res) {
        if (s.length() > 9) {
            return;
        }
        if (!s.isEmpty() && s.charAt(0) != 0) {
            final long num = Long.parseLong(s);
            final long square = num * num;
            if (square > r) {
                return;
            }
            if (isPalindrome(String.valueOf(square))) {
                res[0]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (s.isEmpty()) {
                dfs(String.valueOf(i), r, res);
            }
            dfs(i + s + i, r, res);
        }
    }

    private static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
