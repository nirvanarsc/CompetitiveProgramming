package leetcode.weekly_contests.weekly_200_299.weekly_234;

public class P_1806 {

    public int reinitializePermutation(int n) {
        int i = 1;
        int res = 0;
        do {
            if (i % 2 == 0) {
                i /= 2;
            } else {
                i = n / 2 + i / 2;
            }
            res++;
        } while (i != 1);
        return res;
    }
}
