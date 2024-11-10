package leetcode.medium;

public class P_3133 {

    public long minEnd(int n, int x) {
        final int[] unset = new int[60];
        int idx = 0;
        for (int i = 0; i < 30; i++) {
            if ((x & (1 << i)) == 0) {
                unset[idx++] = i;
            }
        }
        for (int i = idx; i < 60; i++) {
            unset[i] = unset[i - 1] + 1;
        }
        long res = x;
        n--;
        for (int i = 0; i < 30; i++) {
            if ((n & (1 << i)) != 0) {
                res |= 1L << unset[i];
            }
        }
        return res;
    }
}
