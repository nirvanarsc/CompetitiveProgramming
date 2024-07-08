package leetcode.weekly_contests.weekly_400_499.weekly_405;

import java.util.ArrayList;
import java.util.List;

public class P_2 {

    public List<String> validStrings(int n) {
        final List<String> res = new ArrayList<>();
        final String format = "%" + n + 's';
        for (int mask = 0; mask < (1 << n); mask++) {
            final String s = String.format(format, Integer.toBinaryString(mask)).replace(' ', '0');
            if (!s.contains("00")) {
                res.add(s);
            }
        }
        return res;
    }
}
