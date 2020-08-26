package easy;

import java.util.Arrays;

public class P_561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }

    public int arrayPairSumBS(int[] nums) {
        final int n = 10000;
        final int[] buckets = new int[2 * n + 1];
        for (int num : nums) {
            buckets[num + n]++;
        }
        int res = 0;
        boolean add = true;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++, add ^= true) {
                if (add) {
                    res += i - n;
                }
            }
        }
        return res;
    }
}
