package medium;

import java.util.Arrays;

public class P_912 {

    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        final int mid = arr.length >>> 1;
        final int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        final int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        final int[] res = new int[left.length + right.length];
        int i = left.length - 1;
        int j = right.length - 1;
        for (int idx = res.length - 1; i >= 0 || j >= 0; idx--) {
            if (i < 0) {
                res[idx] = right[j--];
            } else if (j < 0) {
                res[idx] = left[i--];
            } else if (left[i] < right[j]) {
                res[idx] = right[j--];
            } else {
                res[idx] = left[i--];
            }
        }
        return res;
    }

    public int[] sortArrayBucketSort(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        final int[] bucket = new int[max - min + 1];
        for (int num : nums) {
            bucket[num - min]++;
        }
        final int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                result[index++] = i + min;
                bucket[i]--;
            }
        }
        return result;
    }
}
