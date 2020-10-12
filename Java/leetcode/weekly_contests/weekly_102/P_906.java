package leetcode.weekly_contests.weekly_102;

public class P_906 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int superpalindromesInRange(String L, String R) {
        final long l = Long.parseLong(L);
        final long r = Long.parseLong(R);
        final int[] res = { 0 };
        dfs("", l, r, res);
        for (int i = 0; i < 10; i++) {
            dfs(String.valueOf(i), l, r, res);
        }
        return res[0];
    }

    private static void dfs(String s, long l, long r, int[] res) {
        if (s.length() > 9) {
            return;
        }

        if (!s.isEmpty() && s.charAt(0) != 0) {
            long num = Long.parseLong(s);
            num *= num;
            if (num > r) { return; }
            if (num >= l && isPalindrome(String.valueOf(num))) {
                res[0]++;
            }
        }

        for (int i = 0; i < 10; i++) {
            dfs(i + s + i, l, r, res);
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
