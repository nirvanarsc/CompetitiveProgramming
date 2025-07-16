package leetcode.weekly_contests.weekly_400_499.weekly_404;

public class P_1 {

    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(f(new int[] { red, blue }), f(new int[] { blue, red }));
    }

    private static int f(int[] u) {
        int res = 0;
        int curr = 1;
        outer:
        while (true) {
            for (int i = 0; i < 2; i++) {
                if (u[i] < curr) {
                    break outer;
                }
                res++;
                u[i] -= curr++;
            }
        }
        return res;
    }
}
