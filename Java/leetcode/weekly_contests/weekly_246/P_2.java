package leetcode.weekly_contests.weekly_246;

public class P_2 {

    public int numberOfRounds(String startTime, String finishTime) {
        final int sh = Integer.parseInt(startTime.substring(0, 2));
        final int sm = Integer.parseInt(startTime.substring(3, 5));

        int eh = Integer.parseInt(finishTime.substring(0, 2));
        final int em = Integer.parseInt(finishTime.substring(3, 5));

        if (sh > eh || sh == eh && sm > em) {
            eh += 24;
        }

        if (sh == eh) {
            return f(sm, em);
        }

        return 4 * (eh - sh - 1) + f(sm, 60) + f(0, em);
    }

    private static int f(int sm, int em) {
        int res = 0;
        int t = 0;
        for (int i = 0; i < 4; i++) {
            if (sm <= t && t + 15 <= em) {
                res++;
            }
            t += 15;
        }
        return res;
    }
}
