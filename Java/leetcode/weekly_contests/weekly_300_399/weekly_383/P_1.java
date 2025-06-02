package leetcode.weekly_contests.weekly_300_399.weekly_383;

public class P_1 {

    public int returnToBoundaryCount(int[] nums) {
        int position = 0;
        int count = 0;
        for (int step : nums) {
            position += step;
            if (position == 0) {
                count++;
            }
        }
        return count;
    }
}
