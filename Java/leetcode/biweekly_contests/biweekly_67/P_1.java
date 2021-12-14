package leetcode.biweekly_contests.biweekly_67;

import java.util.Arrays;
import java.util.Comparator;

public class P_1 {

    public int[] maxSubsequence(int[] nums, int k) {
        final int n = nums.length;
        final int[][] indexed = new int[n][2];
        final int[][] temp = new int[k][2];
        final int[] res = new int[k];
        for (int i = 0; i < n; i++) {
            indexed[i] = new int[] { nums[i], i };
        }
        Arrays.sort(indexed, Comparator.comparingInt(a -> a[0]));
        for (int i = 0, j = n - k; i < k; i++, j++) {
            temp[i] = indexed[j];
        }
        Arrays.sort(temp, Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < k; i++) {
            res[i] = temp[i][0];
        }
        return res;
    }
}
