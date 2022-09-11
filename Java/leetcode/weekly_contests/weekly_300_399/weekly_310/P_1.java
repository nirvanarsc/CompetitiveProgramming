package leetcode.weekly_contests.weekly_300_399.weekly_310;

public class P_1 {

    public int mostFrequentEven(int[] nums) {
        final int[] f = new int[(int) (1e5 + 5)];
        for (int num : nums) {
            if (num % 2 == 0) {
                f[num]++;
            }
        }
        int max = -1;
        for (int i = 0; i < f.length; i += 2) {
            if (f[i] > 0) {
                if (max == -1) {
                    max = i;
                } else if (f[i] > f[max]) {
                    max = i;
                }
            }
        }
        return max;
    }
}
