package leetcode.weekly_contests.weekly_241;

public class P_1855 {

    public int minSwaps(String s) {
        final int n = s.length();
        final int[] f = new int[2];
        for (char c : s.toCharArray()) {
            f[c - '0']++;
        }
        if (n % 2 == 0) {
            if (f[0] != n / 2) {
                return -1;
            }
            return Math.min(count(s, '1', '0'), count(s, '0', '1')) / 2;
        } else {
            if (Math.abs(f[0] - f[1]) > 1) {
                return -1;
            }
            return f[0] > f[1] ? count(s, '0', '1') / 2 : count(s, '1', '0') / 2;
        }
    }

    private static int count(String s, char c1, char c2) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) != c1) {
                    res++;
                }
            } else {
                if (s.charAt(i) != c2) {
                    res++;
                }
            }
        }
        return res;
    }
}
