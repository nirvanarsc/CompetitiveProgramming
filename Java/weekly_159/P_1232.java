package weekly_159;

public class P_1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        final double slope = Math.abs(coordinates[1][1] - coordinates[0][1]) /
                             (double) Math.abs(coordinates[1][0] - coordinates[0][0]);
        for (int i = 1; i < coordinates.length - 1; i++) {
            final double currSlope = Math.abs(coordinates[i + 1][1] - coordinates[i][1])
                                     / (double) Math.abs(coordinates[i + 1][0] - coordinates[i][0]);
            if (Double.compare(currSlope, slope) != 0) {
                return false;
            }
        }
        return true;
    }
}
