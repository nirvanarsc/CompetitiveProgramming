package leetcode.weekly_contests.weekly_300_399.weekly_356;

import java.util.Arrays;

public class P_1 {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours)
                           .filter(hour -> hour >= target)
                           .count();
    }
}
