package leetcode.biweekly_contests.biweekly_0_99.biweekly_51;

import java.util.Arrays;

public class P_1846 {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i - 1] + 1, Math.min(arr[i], i + 1));
        }
        return arr[arr.length - 1];
    }
}
