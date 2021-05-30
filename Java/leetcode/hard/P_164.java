package leetcode.hard;

import java.util.Arrays;

public class P_164 {

    public int maximumGap(int[] nums) {
        final int n = nums.length;
        int min = (int) 1e9;
        int max = (int) -1e9;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) {
            return 0;
        }
        final int gap = (max - min + n - 2) / (n - 1);
        final int buckets = 1 + max / gap;
        final int[] minB = new int[buckets];
        final int[] maxB = new int[buckets];
        Arrays.fill(minB, (int) 1e9);
        for (int num : nums) {
            final int bucket = (num - min) / gap;
            minB[bucket] = Math.min(minB[bucket], num);
            maxB[bucket] = Math.max(maxB[bucket], num);
        }
        int res = 0;
        int prev = maxB[0];
        for (int i = 0; i < buckets; i++) {
            if (minB[i] != (int) 1e9) {
                res = Math.max(res, minB[i] - prev);
                prev = maxB[i];
            }
        }
        return res;
    }
}
