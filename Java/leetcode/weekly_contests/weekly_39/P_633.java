package leetcode.weekly_contests.weekly_39;

public class P_633 {

    public boolean judgeSquareSum(int c) {
        int lo = 0, hi = (int) Math.sqrt(c);
        while (lo <= hi) {
            final int curr = lo * lo + hi * hi;
            if (curr < c) {
                lo++;
            } else if (curr > c) {
                hi--;
            } else {
                return true;
            }
        }
        return false;
    }
}
