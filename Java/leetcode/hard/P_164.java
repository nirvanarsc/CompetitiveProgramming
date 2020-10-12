package leetcode.hard;

import java.util.Arrays;

public class P_164 {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (max == min) {
            return 0;
        }
        final int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        final int buckets = 1 + max / gap;
        final int[] minBuckets = new int[buckets];
        final int[] maxBuckets = new int[buckets];
        Arrays.fill(minBuckets, Integer.MAX_VALUE);
        Arrays.fill(maxBuckets, Integer.MIN_VALUE);
        for (int num : nums) {
            final int bucket = (num - min) / gap;
            minBuckets[bucket] = Math.min(minBuckets[bucket], num);
            maxBuckets[bucket] = Math.max(maxBuckets[bucket], num);
        }
        int res = 0;
        int prev = maxBuckets[0];
        for (int i = 0; i < buckets; i++) {
            if (minBuckets[i] == Integer.MAX_VALUE && maxBuckets[i] == Integer.MIN_VALUE) {
                continue;
            }
            res = Math.max(res, minBuckets[i] - prev);
            prev = maxBuckets[i];
        }
        return res;
    }
}
