package leetcode.weekly_contests.weekly_300_399.weekly_337;

public class P_4 {

    public int findSmallestInteger(int[] nums, int value) {
        final int[] f = new int[value];
        for (int num : nums) {
            f[(num % value + value) % value]++;
        }
        int min = 0;
        for (int i = 0; i < value; i++) {
            if (f[i] < f[min]) {
                min = i;
            }
        }
        return value * f[min] + min;
    }
}
