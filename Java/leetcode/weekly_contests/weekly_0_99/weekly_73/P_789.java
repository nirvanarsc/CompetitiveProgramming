package leetcode.weekly_contests.weekly_0_99.weekly_73;

public class P_789 {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        final int max = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            final int d = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (d <= max) {
                return false;
            }
        }
        return true;
    }
}
