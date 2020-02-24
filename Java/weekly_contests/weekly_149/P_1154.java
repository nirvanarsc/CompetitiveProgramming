package weekly_contests.weekly_149;

public class P_1154 {

    int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int dayOfYear(String date) {
        final String[] split = date.split("-");
        final int y = Integer.valueOf(split[0]);
        final int m = Integer.valueOf(split[1]);
        final int d = Integer.valueOf(split[2]);
        final boolean leapYear = (y % 100 == 0) ? (y % 400 == 0) : (y % 4 == 0);
        int res = 0;
        for (int i = 1; i < m; i++) {
            res += months[i];
            if (i == 2 && leapYear) {
                res++;
            }
        }
        return res + d;
    }
}
