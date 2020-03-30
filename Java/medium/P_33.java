package medium;

import java.util.Arrays;

public final class P_33 {

    public static int search(int[] nums, int target) {
        int low = findSmallest(nums);
        int high = low + nums.length - 1;

        while (low <= high) {
            final int mid = low + high >>> 1;
            if (nums[mid % nums.length] == target) {
                return mid % nums.length;
            } else if (nums[mid % nums.length] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private static int findSmallest(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            final int mid = low + high >>> 1;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static int search2(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            final int mid = (low + high) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[low]) {
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

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
        System.out.println(search(new int[] { 1 }, 1));
    }

    public static int searchNew(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        final int bs1 = Arrays.binarySearch(nums, 0, lo, target);
        final int bs2 = Arrays.binarySearch(nums, lo, nums.length, target);
        return bs1 >= 0 ? bs1 : bs2 >= 0 ? bs2 : -1;
    }

    private P_33() {}
}
