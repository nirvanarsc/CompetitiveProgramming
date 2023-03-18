package leetcode.biweekly_contests.biweekly_0_99.biweekly_53;

public class P_1 {

    public int countGoodSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (f(s.substring(i, i + 3))) {
                res++;
            }
        }
        return res;
    }

    private static boolean f(String s) {
        return s.charAt(0) != s.charAt(1) && s.charAt(0) != s.charAt(2) && s.charAt(1) != s.charAt(2);
    }
}
