package leetcode.weekly_contests.weekly_283;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public List<String> cellsInRange(String s) {
        final int l = s.charAt(1) - '0';
        final int r = s.charAt(4) - '0';
        final char ll = s.charAt(0);
        final char rr = s.charAt(3);
        final List<String> res = new ArrayList<>();
        for (char c = ll; c <= rr; c++) {
            for (int k = l; k <= r; k++) {
                res.add(String.valueOf(c) + k);
            }
        }
        return res;
    }
}
