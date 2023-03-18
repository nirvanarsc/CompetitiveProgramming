package leetcode.biweekly_contests.biweekly_0_99.biweekly_47;

public class P_1780 {

    public boolean checkPowersOfThree(int n) {
        final int[] pows = new int[16];
        int p = 1;
        for (int i = 0; i < 16; i++) {
            pows[i] = p;
            p *= 3;
        }
        for (int mask = 0; mask < (1 << 16); mask++) {
            long curr = 0;
            for (int i = 0; i < 16; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr += pows[i];
                }
            }
            if (curr == n) {
                return true;
            }
        }
        return false;
    }
}
