package leetcode.weekly_contests.weekly_197;

public class P_1515 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    double lowerLimit = 1e-5;

    public double getMinDistSum(int[][] positions) {
        final int n = positions.length;
        final double[] curr = { 0.0, 0.0 };
        for (int[] position : positions) {
            curr[0] += position[0];
            curr[1] += position[1];
        }
        curr[0] /= n;
        curr[1] /= n;
        double minDist = distSum(curr, positions, n);
        double testDistance = 1;
        outer:
        while (testDistance > lowerLimit) {
            for (int[] dir : DIRS) {
                final double[] newPoint = { curr[0] + testDistance * dir[0], curr[1] + testDistance * dir[1] };
                final double newD = distSum(newPoint, positions, n);
                if (newD < minDist) {
                    minDist = newD;
                    curr[0] = newPoint[0];
                    curr[1] = newPoint[1];
                    continue outer;
                }
            }
            testDistance /= 2;
        }
        return minDist;
    }

    private static double distSum(double[] p, int[][] positions, int n) {
        double sum = 0;
        for (int[] pos : positions) {
            final double distx = Math.abs(pos[0] - p[0]);
            final double disty = Math.abs(pos[1] - p[1]);
            sum += Math.hypot(distx, disty);
        }
        return sum;
    }
}
