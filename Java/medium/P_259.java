package medium;

import java.util.Arrays;

public class P_259 {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] < target) {
                    res += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}
