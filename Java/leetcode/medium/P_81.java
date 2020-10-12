package leetcode.medium;

import java.util.stream.IntStream;

public final class P_81 {

    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            final int mid = (low + high) >>> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[low]) {
                low++;
            } else if (nums[mid] > nums[low]) {
                if (nums[mid] > target && nums[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        final int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        IntStream.range(0, 11).forEach(i -> System.out.println(i + " " + search(nums, i)));

        System.out.println(search(new int[] { 2, 2, 2, 0, 2, 2 }, 0));
    }

    private P_81() {}
}
