package leetcode.biweekly_contests.biweekly_30;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1507 {

    public String reformatDate(String date) {
        final String[] split = date.split(" ");
        final Map<String, String> map = new HashMap<>();
        final List<String> months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                                  "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        for (int i = 0; i < months.size(); i++) {
            map.put(months.get(i), String.format("%02d", i + 1));
        }
        final String day = split[0].substring(0, split[0].length() - 2);
        return split[2] + '-' + map.get(split[1]) + '-' + String.format("%02d", Integer.parseInt(day));
    }
}
