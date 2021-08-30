package leetcode.weekly_contests.weekly_34;

public class P_598 {

    public int maxCount(int m, int n, int[][] ops) {
        int minX = m;
        int minY = n;
        for (int[] op : ops) {
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }
        return minX * minY;
    }
}
