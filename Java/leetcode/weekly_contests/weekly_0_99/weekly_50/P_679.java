package leetcode.weekly_contests.weekly_0_99.weekly_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_679 {

    public boolean judgePoint24(int[] nums) {
        final List<Double> arr = new ArrayList<>();
        for (int n : nums) {
            arr.add((double) n);
        }
        return helper(arr);
    }

    @SuppressWarnings("SuspiciousListRemoveInLoop")
    private static boolean helper(List<Double> arr) {
        if (arr.size() == 1) {
            return Math.abs(arr.get(0) - 24.0) < 0.001;
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                final Double p1 = arr.get(i);
                final Double p2 = arr.get(j);
                final List<Double> next = new ArrayList<>(
                        Arrays.asList(p1 + p2, p1 - p2, p2 - p1, p1 * p2, p1 / p2, p2 / p1));
                arr.remove(j);
                arr.remove(i);
                for (Double n : next) {
                    arr.add(n);
                    if (helper(arr)) {
                        return true;
                    }
                    arr.remove(arr.size() - 1);
                }
                arr.add(i, p1);
                arr.add(j, p2);
            }
        }
        return false;
    }
}
