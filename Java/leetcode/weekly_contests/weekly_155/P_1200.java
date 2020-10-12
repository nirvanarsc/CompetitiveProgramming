package leetcode.weekly_contests.weekly_155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        final List<List<Integer>> res = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            diff = Math.min(diff, Math.abs(arr[i] - arr[i + 1]));
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) == diff) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
}
