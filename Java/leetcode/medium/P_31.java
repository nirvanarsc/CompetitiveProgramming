package leetcode.medium;

import java.util.Arrays;

public final class P_31 {

    public static void nextPermutation(int[] nums) {
        int idx = nums.length - 1, swapIdx = nums.length - 1;

        while (idx != 0 && nums[idx - 1] >= nums[idx]) {
            idx--;
        }

        if (idx == 0) {
            reverse(0, nums.length - 1, nums);
            return;
        }

        idx -= 1;
        while (nums[swapIdx] <= nums[idx]) {
            swapIdx--;
        }

        final int temp = nums[idx];
        nums[idx] = nums[swapIdx];
        nums[swapIdx] = temp;

        reverse(idx + 1, nums.length - 1, nums);
    }

    private static void reverse(int from, int to, int[] arr) {
        for (int i = from; 2 * i < to + from; i++) {
            final int temp = arr[i];
            arr[i] = arr[to + from - i];
            arr[to + from - i] = temp;
        }
    }

    public static void main(String[] args) {
        test(new int[] { 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
        test(new int[] { 2, 3, 1 });
        test(new int[] { 1, 3, 2 });
        test(new int[] { 1, 1, 5 });
        test(new int[] { 1, 5, 1 });
    }

    private static void test(int[] nums) {
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println();
    }

    private P_31() {}
}
