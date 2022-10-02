package leetcode.weekly_contests.weekly_300_399.weekly_313;

public class P_3 {

    public int minimizeXor(int num1, int num2) {
        int n = Integer.bitCount(num2);
        int res = 0;
        for (int i = 31; i >= 0 && n > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                res |= 1 << i;
                n--;
            }
        }
        int idx = 0;
        while (n > 0) {
            if ((res & (1 << idx)) == 0) {
                res |= 1 << idx;
                n--;
            }
            idx++;
        }
        return res;
    }
}
