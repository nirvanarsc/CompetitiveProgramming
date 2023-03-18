package leetcode.biweekly_contests.biweekly_0_99.biweekly_9;

import java.util.Arrays;

public class P_1196 {

    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0, w = 5000; i < arr.length; i++) {
            w -= arr[i];
            if (w < 0) {
                return res;
            }
            res++;
        }
        return res;
    }
}
