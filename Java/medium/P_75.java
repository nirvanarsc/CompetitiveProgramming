package medium;

import java.util.Arrays;

public final class P_75 {

    public static void sortColors(int[] nums) {
        final int pivot = 1;
        int smaller = 0, equal = 0, higher = nums.length - 1;

        while (equal <= higher) {
            if (nums[equal] < pivot) {
                swap(nums, smaller, equal);
                equal++;
                smaller++;
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

    public static void main(String[] args) {
        final int[] ints = { 2, 1, 2, 1, 2, 1, 0, 1, 2, 1, 2, 0 };
        System.out.println(Arrays.toString(ints));
        sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }

    private P_75() {}
}
