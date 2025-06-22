package leetcode.weekly_contests.weekly_400_499.weekly_450;

import java.util.Arrays;

public class P_2 {

    public int minSwaps(int[] nums) {
        final int n = nums.length;
        final int[][] list = new int[n][];
        for (int i = 0; i < n; i++) {
            list[i] = new int[] { f(nums[i]), nums[i], i };
        }
        Arrays.sort(list, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1])
                                                 : Integer.compare(a[0], b[0]));
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (list[i][2] != i) {
                res++;
                swap(list, i, list[i][2]);
                // workaround instead of using a visited array for a cycle, keep re-checking i until its fixed
                i--;
            }
        }
        return res;
    }

    private static void swap(int[][] list, int l, int r) {
        final int[] temp = list[l];
        list[l] = list[r];
        list[r] = temp;
    }

    private static int f(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
