package leetcode.weekly_contests.weekly_250;

public class P_2 {

    public int addRungs(int[] rungs, int dist) {
        int prev = 0;
        int res = 0;
        for (int r : rungs) {
            final int d = r - prev;
            res += (d + dist - 1) / dist;
            res -= 1;
            prev = r;
        }
        return res;
    }
}
