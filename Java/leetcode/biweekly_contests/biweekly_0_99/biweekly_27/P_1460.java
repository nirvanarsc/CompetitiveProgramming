package leetcode.biweekly_contests.biweekly_0_99.biweekly_27;

import java.util.Arrays;

public class P_1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
