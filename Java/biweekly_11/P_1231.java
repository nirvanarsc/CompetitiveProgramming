package biweekly_11;

public class P_1231 {

    public int maximizeSweetness(int[] sweetness, int k) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i : sweetness) {
            sum += i;
            min = Math.min(min, i);
        }

        int lo = min;
        int hi = sum;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (cut(sweetness, mid) >= k + 1) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private static int cut(int[] sweetness, int mid) {
        int cuts = 0;
        int currSum = 0;
        for (int i : sweetness) {
            currSum += i;
            if (currSum >= mid) {
                cuts++;
                currSum = 0;
            }
        }
        return cuts;
    }
}
