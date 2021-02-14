package leetcode.weekly_contests.weekly_228;

public class P_1759 {

    private static final int MOD = (int) 1e9 + 7;

    public int countHomogenous(String s) {
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            final long curr = j - i;
            final long add = (curr * (curr + 1)) / 2;
            res = (res + add) % MOD;
            i = j - 1;
        }
        return (int) res;
    }
}
