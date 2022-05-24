package leetcode.weekly_contests.weekly_0_99.weekly_47;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P_667 {

    public int[] constructArray(int n, int k) {
        final int[] res = new int[n];
        boolean lowOrHigh = true;
        int lo = 1, hi = n;
        for (int i = 0; i < k; i++) {
            res[i] = lowOrHigh ? lo++ : hi--;
            lowOrHigh ^= true;
        }
        for (int i = k; i < n; i++) {
            res[i] = lowOrHigh ? hi-- : lo++;
        }
        return res;
    }

    public int[] constructArrayReverse(int n, int k) {
        final List<Integer> nums = IntStream.rangeClosed(1, n)
                                            .boxed()
                                            .collect(Collectors.toList());
        for (int i = 1; i < k; i++) {
            Collections.reverse(nums.subList(i, nums.size()));
        }
        return nums.stream().mapToInt(Integer::intValue).toArray();
    }
}
