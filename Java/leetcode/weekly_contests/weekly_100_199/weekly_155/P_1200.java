package leetcode.weekly_contests.weekly_100_199.weekly_155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        final int n = arr.length;
        final List<List<Integer>> res = new ArrayList<>();
        int min = (int) 1e9;
        for (int i = 0; i < (n - 1); i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }
        for (int i = 0; i < (n - 1); i++) {
            if (arr[i + 1] - arr[i] == min) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
}
