package leetcode.weekly_contests.weekly_157;

public class P_1217 {

    public int minCostToMoveChips(int[] position) {
        final int[] f = new int[2];
        for (int pos : position) {
            f[pos % 2]++;
        }
        return Math.min(f[0], f[1]);
    }
}
