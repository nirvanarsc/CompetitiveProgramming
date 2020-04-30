package weekly_contests.weekly_31;

public class P_573 {

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int sum = 0, maxDiff = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            final int dist = distance(tree, nut);
            sum += 2 * dist;
            maxDiff = Math.max(maxDiff, dist - distance(squirrel, nut));
        }
        return sum - maxDiff;
    }

    public int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
