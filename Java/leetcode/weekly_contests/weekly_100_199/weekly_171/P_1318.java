package leetcode.weekly_contests.weekly_100_199.weekly_171;

public class P_1318 {

    public int minFlips(int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            final boolean bitA = getBit(a, i);
            final boolean bitB = getBit(b, i);
            final boolean bitC = getBit(c, i);
            if (bitC) {
                if (!bitA && !bitB) {
                    count++;
                }
            } else {
                if (bitA) { count++; }
                if (bitB) { count++; }
            }
        }
        return count;
    }

    public static boolean getBit(int n, int j) {
        return (n & (1 << j)) != 0;
    }
}
