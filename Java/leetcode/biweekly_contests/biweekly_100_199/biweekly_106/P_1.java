package leetcode.biweekly_contests.biweekly_100_199.biweekly_106;

public class P_1 {

    public boolean isFascinating(int n) {
        final String w = String.valueOf(n) + 2 * n + 3 * n;
        int mask = 1;
        for (char c : w.toCharArray()) {
            if ((mask & (1 << (c - '0'))) != 0) {
                return false;
            }
            mask |= 1 << (c - '0');
        }
        return Integer.bitCount(mask) == 10;
    }
}
