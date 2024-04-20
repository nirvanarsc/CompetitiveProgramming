package leetcode.weekly_contests.weekly_300_399.weekly_372;

public class P_2 {

    public long minimumSteps(String s) {
        final int n = s.length();
        long res = 0;
        int curr = 0;
        final char[] w = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            curr += w[i] == '0' ? 1 : 0;
            res += w[i] == '1' ? curr : 0;
        }
        return res;
    }
}
