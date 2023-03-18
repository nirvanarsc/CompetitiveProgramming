package leetcode.biweekly_contests.biweekly_0_99.biweekly_37;

import java.util.Arrays;

public class P_1619 {

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        final int n = arr.length;
        final int five = arr.length / 20;
        long sum = 0;
        for (int i = five; i < n - five; i++) {
            sum += arr[i];
        }
        return sum / (double) (n - 2 * five);
    }
}
