package leetcode.weekly_contests.weekly_127;

public class P_1007 {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = (int) 1e9;
        for (int t = 1; t <= 6; t++) {
            res = Math.min(res, f(tops, bottoms, t));
            res = Math.min(res, f(bottoms, tops, t));
        }
        return res == (int) 1e9 ? -1 : res;
    }

    private static int f(int[] l, int[] r, int t) {
        final int n = l.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (l[i] == t) {
                continue;
            } else if (r[i] == t) {
                res++;
            } else {
                return (int) 1e9;
            }
        }
        return res;
    }
}
