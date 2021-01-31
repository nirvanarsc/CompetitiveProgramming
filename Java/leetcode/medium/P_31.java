package leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class P_31 {

    public void nextPermutation(int[] nums) {
        final List<Integer> boxed = Arrays.stream(nums).boxed().collect(Collectors.toList());
        nextPermutation(boxed);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxed.get(i);
        }
    }

    private static void nextPermutation(List<Integer> arr) {
        final int n = arr.size();
        int i = n - 2;
        while (i >= 0 && arr.get(i) >= arr.get(i + 1)) {
            i--;
        }
        if (i == -1) {
            Collections.reverse(arr);
            return;
        }
        int swap = n - 1;
        while (arr.get(i) >= arr.get(swap)) {
            swap--;
        }
        Collections.swap(arr, i, swap);
        Collections.reverse(arr.subList(i + 1, n));
    }
}
