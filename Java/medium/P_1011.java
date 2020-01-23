package medium;

public class P_1011 {

    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : weights) {
            max = Math.max(max, i);
            sum += i;
        }
        int lo = max;
        int hi = sum;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            final int days = getDays(weights, mid);
            if (days > D) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int getDays(int[] weights, int cap) {
        int d = 1;
        int curr = 0;
        for (int w : weights) {
            if (w + curr > cap) {
                d++;
                curr = 0;
            }
            curr += w;
        }
        return d;
    }
}
