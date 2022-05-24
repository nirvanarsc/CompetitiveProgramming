package leetcode.weekly_contests.weekly_0_99.weekly_53;

public class P_693 {

    public boolean hasAlternatingBits(int n) {
        int flag = n & 1;
        while (n > 0) {
            if ((n & 1) != flag) {
                return false;
            }
            flag ^= 1;
            n >>= 1;
        }
        return true;
    }

    public static boolean hasAlternatingBitsSmart(int n) {
        n ^= n >> 1;
        return (n & n + 1) == 0;
    }
}
