package leetcode.weekly_contests.weekly_0_99.weekly_79;

public class P_812 {

    // https://www.mathopenref.com/coordtrianglearea.html
    // https://www.mathopenref.com/heronsformula.html
    // https://www.mathopenref.com/coordtriangleareabox.html
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for (int[] i : points) {
            for (int[] j : points) {
                for (int[] k : points) {
                    res = Math.max(res, 0.5 * Math.abs(getArea(i, j, k)));
                }
            }
        }
        return res;
    }

    private static int getArea(int[] i, int[] j, int[] k) {
        return i[0] * j[1] + j[0] * k[1] + k[0] * i[1] - j[0] * i[1] - k[0] * j[1] - i[0] * k[1];
    }
}
