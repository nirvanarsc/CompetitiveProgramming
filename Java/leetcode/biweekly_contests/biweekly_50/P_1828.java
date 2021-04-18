package leetcode.biweekly_contests.biweekly_50;

public class P_1828 {

    public int[] countPoints(int[][] points, int[][] queries) {
        final int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int curr = 0;
            for (int[] p : points) {
                if (isInside(queries[i], p[0], p[1])) {
                    curr++;
                }
            }
            res[i] = curr;
        }
        return res;
    }

    private static boolean isInside(int[] circle, int x, int y) {
        return (x - circle[0]) * (x - circle[0]) + (y - circle[1]) * (y - circle[1]) <= circle[2] * circle[2];
    }
}
