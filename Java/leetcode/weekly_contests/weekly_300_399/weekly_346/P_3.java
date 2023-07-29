package leetcode.weekly_contests.weekly_300_399.weekly_346;

public class P_3 {

    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += f(i) ? i * i : 0;
        }
        return res;
    }

    private static boolean f(int num) {
        final String v = String.valueOf(num * num);
        final int n = v.length();
        for (int mask = 0; mask < (1 << (n - 1)); mask++) {
            int total = 0;
            int curr = 0;
            for (int i = 0; i < n - 1; i++) {
                curr += v.charAt(i) - '0';
                if ((mask & (1 << i)) != 0) {
                    total += curr;
                    curr = 0;
                } else {
                    curr *= 10;
                }
            }
            curr += v.charAt(n - 1) - '0';
            total += curr;
            if (total == num) {
                return true;
            }
        }
        return false;
    }
}
