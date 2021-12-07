package leetcode.weekly_contests.weekly_270;

public class P_1 {

    public int[] findEvenNumbers(int[] digits) {
        final int n = (int) 1e3;
        final boolean[] ok = new boolean[n];
        final int[] d = new int[10];
        for (int digit : digits) {
            d[digit]++;
        }
        int count = 0;
        for (int num = 100; num < n; num += 2) {
            boolean curr = true;
            int copy = num;
            final int[] f = new int[10];
            while (copy > 0) {
                f[copy % 10]++;
                copy /= 10;
            }
            for (int i = 0; i < 10; i++) {
                curr &= d[i] >= f[i];
            }
            if (curr) {
                count++;
                ok[num] = true;
            }
        }
        final int[] res = new int[count];
        for (int num = 998; num >= 100; num -= 2) {
            if (ok[num]) {
                res[--count] = num;
            }
        }
        return res;
    }
}
