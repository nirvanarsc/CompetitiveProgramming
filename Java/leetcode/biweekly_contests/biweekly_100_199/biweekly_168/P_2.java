package leetcode.biweekly_contests.biweekly_100_199.biweekly_168;

public class P_2 {

    public String maxSumOfSquares(int num, int sum) {
        final char[] res = new char[num];
        for (int i = 0; i < num; i++) {
            final int u = Math.min(sum, 9);
            res[i] = (char) ('0' + u);
            sum -= u;
        }
        return sum > 0 ? "" : new String(res);
    }
}
