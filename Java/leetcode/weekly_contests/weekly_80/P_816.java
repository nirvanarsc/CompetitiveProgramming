package leetcode.weekly_contests.weekly_80;

import java.util.ArrayList;
import java.util.List;

public class P_816 {

    public List<String> ambiguousCoordinates(String s) {
        final List<String> res = new ArrayList<>();
        for (int i = 2; i < s.length() - 1; i++) {
            for (String l : f(s.substring(1, i))) {
                for (String r : f(s.substring(i, s.length() - 1))) {
                    res.add(String.format("(%s, %s)", l, r));
                }
            }
        }
        return res;
    }

    private static List<String> f(String w) {
        final List<String> res = new ArrayList<>();
        if (ok(w)) {
            res.add(w);
        }
        if (w.charAt(w.length() - 1) == '0') {
            return res;
        }
        for (int i = 1; i < w.length(); i++) {
            final String l = w.substring(0, i);
            final String r = w.substring(i);
            if (ok(l)) {
                res.add(String.format("%s.%s", l, r));
            } else {
                break;
            }
        }
        return res;
    }

    private static boolean ok(String w) {
        return w.length() == 1 || w.charAt(0) != '0';
    }
}
