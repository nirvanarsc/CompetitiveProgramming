package weekly_contests.weekly_135;

public class P_1037 {

    public boolean isBoomerang(int[][] points) {
        final int slope1 = (points[0][0] - points[1][0]) * (points[1][1] - points[2][1]);
        final int slope2 = (points[1][0] - points[2][0]) * (points[0][1] - points[1][1]);

        return slope1 != slope2;
    }
}
