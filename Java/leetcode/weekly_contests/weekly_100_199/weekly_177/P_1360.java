package leetcode.weekly_contests.weekly_100_199.weekly_177;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class P_1360 {

    public int daysBetweenDates(String date1, String date2) {
        return (int) Math.abs(ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)));
    }
}
