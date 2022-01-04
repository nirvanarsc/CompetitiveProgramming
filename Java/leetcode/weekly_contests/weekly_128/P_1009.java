package leetcode.weekly_contests.weekly_128;

public class P_1009 {

    public int bitwiseComplement(int n) {
        int msb = 0;
        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                msb = i;
                break;
            }
        }
        final int mask = (1 << (msb + 1)) - 1;
        return mask & ~n;
    }
}
