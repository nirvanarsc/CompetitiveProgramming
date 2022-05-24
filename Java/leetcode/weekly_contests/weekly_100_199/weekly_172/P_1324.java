package leetcode.weekly_contests.weekly_100_199.weekly_172;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P_1324 {

    public List<String> printVertically(String s) {
        final List<StringBuilder> res = new ArrayList<>();
        final String[] split = s.split(" ");
        int longest = 0;
        for (String str : split) {
            longest = Math.max(longest, str.length());
        }
        for (int i = 0; i < longest; i++) {
            res.add(new StringBuilder());
            for (String str : split) {
                if (i < str.length()) {
                    res.get(i).append(str.charAt(i));
                } else {
                    res.get(i).append(' ');
                }
            }
        }
        return res.stream()
                  .map(i -> i.toString().replaceFirst("\\s+$", ""))
                  .collect(Collectors.toList());
    }
}
