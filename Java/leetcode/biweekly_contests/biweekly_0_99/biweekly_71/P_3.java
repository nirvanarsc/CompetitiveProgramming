package leetcode.biweekly_contests.biweekly_0_99.biweekly_71;

public class P_3 {

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        final int mins = targetSeconds / 60;
        final int sec = targetSeconds % 60;
        final int l = f(startAt, moveCost, pushCost, getW(mins, sec));
        final int r = f(startAt, moveCost, pushCost, getW(mins - 1, sec + 60));
        if (mins == 100) {
            return r;
        }
        if (mins == 0 || sec > 39) {
            return l;
        }
        return Math.min(l, r);
    }

    private static char[] getW(int mins, int sec) {
        final StringBuilder sb = new StringBuilder();
        if (mins > 0) {
            sb.append(mins);
        }
        if (sb.length() > 0 && sec < 10) {
            sb.append('0');
        }
        sb.append(sec);
        return sb.toString().toCharArray();
    }

    private static int f(int s, int m, int p, char[] w) {
        int res = 0;
        for (char c : w) {
            if (s != c - '0') {
                res += m;
                s = c - '0';
            }
            res += p;
        }
        return res;
    }
}
