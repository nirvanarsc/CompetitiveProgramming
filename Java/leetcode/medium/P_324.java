package leetcode.medium;

import static utils.NthElement.findKthLargest;

public class P_324 {

    public void wiggleSort(int[] nums) {
        final int median = findKthLargest(nums, nums.length / 2);
        sortColors(nums, median);
    }

    public static void sortColors(int[] nums, int pivot) {
        final int n = nums.length;
        int smaller = 0, equal = 0, higher = n - 1;
        while (equal <= higher) {
            final int virtualMid = virtualIndex(equal, n);
            if (nums[virtualMid] > pivot) {
                swap(nums, virtualMid, virtualIndex(smaller, n));
                smaller++;
                equal++;
            } else if (nums[virtualMid] == pivot) {
                equal++;
            } else {
                swap(nums, virtualMid, virtualIndex(higher, n));
                higher--;
            }
        }
    }

    public static int virtualIndex(int i, int n) {
        return (2 * i + 1) % (n | 1);
    }

    private static void swap(int[] nums, int i, int j) {
        final int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
