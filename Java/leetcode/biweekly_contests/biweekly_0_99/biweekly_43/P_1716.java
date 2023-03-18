package leetcode.biweekly_contests.biweekly_0_99.biweekly_43;

public class P_1716 {

    public int totalMoney(int n) {
        final int full = n / 7;
        final int rem = n % 7;
        int res = ((7 * 8) / 2) * full;
        res += 7 * (((full - 1) * full) / 2);
        res += (rem * (rem + 1)) / 2;
        res += full * rem;
        return res;
    }
}
