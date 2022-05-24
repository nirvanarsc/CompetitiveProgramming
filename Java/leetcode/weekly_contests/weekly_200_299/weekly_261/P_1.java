package leetcode.weekly_contests.weekly_200_299.weekly_261;

public class P_1 {

    public int minimumMoves(String s) {
        final int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'X') {
                res++;
                i += 2;
            }
        }
        return res;
    }
}
