package leetcode.weekly_contests.weekly_200_299.weekly_288;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_1 {

    public int largestInteger(int num) {
        final char[] w = Integer.toString(num).toCharArray();
        final List<Integer> l = new ArrayList<>();
        final List<Integer> r = new ArrayList<>();
        for (char c : w) {
            if (c % 2 == 0) {
                l.add(c - '0');
            } else {
                r.add(c - '0');
            }
        }
        l.sort(Comparator.reverseOrder());
        r.sort(Comparator.reverseOrder());
        for (int i = 0; i < w.length; i++) {
            if (w[i] % 2 == 0) {
                w[i] = (char) (l.remove(0) + '0');
            } else {
                w[i] = (char) (r.remove(0) + '0');
            }
        }
        return Integer.parseInt(new String(w));
    }
}
