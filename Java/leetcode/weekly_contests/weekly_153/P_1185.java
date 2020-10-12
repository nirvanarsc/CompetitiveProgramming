package leetcode.weekly_contests.weekly_153;

import java.time.LocalDate;

public class P_1185 {

    String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

    public String dayOfTheWeek(int day, int month, int year) {
        return days[(LocalDate.of(year, month, day).getDayOfWeek().ordinal() + 1) % 7];
    }

    // https://en.wikipedia.org/wiki/Zeller's_congruence
    public String dayOfTheWeekZeller(int d, int m, int y) {
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        final int c = y / 100;
        y %= 100;
        final int w = (c / 4 - 2 * c + y + y / 4 + 13 * (m + 1) / 5 + d - 1) % 7;
        return days[(w + 7) % 7];
    }
}
