package leetcode.weekly_contests.weekly_100_199.weekly_139;

public class P_1071 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public String gcdOfStrings(String str1, String str2) {
        final int n = str1.length();
        final int m = str2.length();
        final int d = gcd(n, m);
        final String s = str1.substring(0, d);
        final String str = str1 + str2;
        for (int i = 0; i < n + m; i += d) {
            if (!str.startsWith(s, i)) {
                return "";
            }
        }
        return s;
    }
}
