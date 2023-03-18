package leetcode.biweekly_contests.biweekly_0_99.biweekly_37;

@SuppressWarnings("ConstantConditions")
public class P_1620 {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] res = null;
        int max = 0;
        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                final int[] curr = { x, y };
                int currQ = 0;
                for (int[] tower : towers) {
                    final int d = dist(curr, tower);
                    if (radius * radius >= d) {
                        currQ += (int) (tower[2] / (1.0 + Math.sqrt(d)));
                    }
                }
                if (max < currQ) {
                    max = currQ;
                    res = curr;
                }
            }
        }
        return res;
    }

    private static int dist(int[] a, int[] b) {
        final int dx = Math.abs(a[0] - b[0]);
        final int dy = Math.abs(a[1] - b[1]);
        return dx * dx + dy * dy;
    }
}
