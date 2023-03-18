package leetcode.biweekly_contests.biweekly_0_99.biweekly_4;

public class P_1118 {

    public int numberOfDays(int y, int m) {
        final int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        final boolean leapYear = (y % 100 == 0) ? (y % 400 == 0) : (y % 4 == 0);
        return months[m] + ((m == 2 && leapYear) ? 1 : 0);
    }
}
