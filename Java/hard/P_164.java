package hard;

import java.util.Arrays;

public class P_164 {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        final int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        final int[] bucketsMIN = new int[nums.length - 1];
        final int[] bucketsMAX = new int[nums.length - 1];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == min || num == max) {
                continue;
            }
            final int idx = (num - min) / gap;
            bucketsMIN[idx] = Math.min(num, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(num, bucketsMAX[idx]);
        }
        int maxGap = 0;
        int previous = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}
