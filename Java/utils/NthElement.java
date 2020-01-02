package utils;

public final class NthElement {

    public static int findKthLargest(int[] nums, int k) {
        return select(nums, k - 1);
    }

    // Quick Select
    private static int select(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            if (left == right) {
                return nums[left];
            }
            int pivotIndex = medianOf3(nums, left, right);
            pivotIndex = partition(nums, left, right, pivotIndex);
            if (pivotIndex == k) {
                return nums[k];
            } else if (pivotIndex > k) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    //Use median-of-three strategy to choose pivot
    private static int medianOf3(int[] nums, int left, int right) {
        final int mid = left + (right - left) / 2;
        if (nums[right] > nums[left]) { swap(nums, left, right); }
        if (nums[right] > nums[mid]) { swap(nums, right, mid); }
        if (nums[mid] > nums[left]) { swap(nums, left, mid); }
        return mid;
    }

    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        final int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int index = left;
        for (int i = left; i < right; ++i) {
            if (nums[i] > pivotValue) {
                swap(nums, index, i);
                ++index;
            }
        }
        swap(nums, right, index);
        return index;
    }

    private static void swap(int[] nums, int a, int b) {
        final int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private NthElement() {}
}
