package leetcode.medium;

public class P_75 {

    public void sortColors(int[] nums) {
        final int pivot = 1;
        final int n = nums.length;
        int smaller = 0;
        int equal = 0;
        int higher = n - 1;
        while (equal <= higher) {
            if (nums[equal] < pivot) {
                swap(nums, smaller, equal);
                smaller++;
                equal++;
            } else if (nums[equal] == pivot) {
                equal++;
            } else {
                swap(nums, equal, higher);
                higher--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        final int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
