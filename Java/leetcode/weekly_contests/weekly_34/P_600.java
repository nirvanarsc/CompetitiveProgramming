package leetcode.weekly_contests.weekly_34;

public class P_600 {

    public int findIntegers(int num) {
        final int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        int i = 30, sum = 0, prev = 0;
        while (i >= 0) {
            if ((num & (1 << i)) != 0) {
                sum += f[i];
                if (prev == 1) {
                    sum--;
                    break;
                }
                prev = 1;
            } else {
                prev = 0;
            }
            i--;
        }
        return sum + 1;
    }
}
