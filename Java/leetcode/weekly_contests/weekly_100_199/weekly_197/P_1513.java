package leetcode.weekly_contests.weekly_100_199.weekly_197;

public class P_1513 {

    private static final int MOD = (int) (1e9 + 7);

    public int numSub(String s) {
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                int j = i;
                while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                res = (res + (long) (j - i) * (j - i + 1) / 2) % MOD;
                i = j;

            }
        }
        return (int) res;
    }
}
