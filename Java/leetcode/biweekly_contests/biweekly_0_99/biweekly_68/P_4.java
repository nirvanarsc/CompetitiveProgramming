package leetcode.biweekly_contests.biweekly_0_99.biweekly_68;

public class P_4 {

    public String abbreviateProduct(int left, int right) {
        long suf = 1;
        double pre = 1;
        final long max_suf = (long) 1e11;
        final long max_pre = (long) 1e5;
        long org_dig = 0;
        int zeros = 0;
        for (int i = left; i <= right; i++) {
            pre *= i;
            suf *= i;
            while (pre >= max_pre) {
                if (org_dig == 0) {
                    org_dig += 5;
                } else {
                    org_dig++;
                }
                pre /= 10;
            }
            while (suf % 10 == 0) {
                zeros++;
                suf /= 10;
            }
            suf %= max_suf;
        }
        final String s = String.valueOf(suf);
        if (org_dig - zeros <= 10) {
            return s + 'e' + zeros;
        }
        return (int) pre + "..." + s.substring(s.length() - 5) + 'e' + zeros;
    }
}
