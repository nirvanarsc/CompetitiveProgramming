package leetcode.weekly_contests.weekly_300_399.weekly_360;

public class P_1 {

    public int furthestDistanceFromOrigin(String moves) {
        final int[] f = new int[3];
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                f[0]++;
            } else if (c == 'R') {
                f[1]++;
            } else {
                f[2]++;
            }
        }
        return Math.abs(f[0] - f[1]) + f[2];
    }
}
