package leetcode.weekly_contests.weekly_290;

public class P_2 {

    public int countLatticePoints(int[][] circles) {
        int res = 0;
        for (int x = 0; x < 205; x++) {
            for (int y = 0; y < 205; y++) {
                for (int[] circle : circles) {
                    if (checkOverlap(circle, x, y)) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public boolean checkOverlap(int[] circle, int x, int y) {
        final int deltaX = circle[0] - x;
        final int deltaY = circle[1] - y;
        return (deltaX * deltaX + deltaY * deltaY) <= (circle[2] * circle[2]);
    }
}
