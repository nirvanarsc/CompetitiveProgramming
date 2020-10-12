package leetcode.weekly_contests.weekly_23;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_539 {

    public int findMinDifference(List<String> timePoints) {
        final List<Integer> hash = new ArrayList<>();
        for (String t : timePoints) {
            final int hours = Integer.parseInt(t.substring(0, 2));
            final int mins = Integer.parseInt(t.substring(3));
            hash.add((24 + hours) * 60 + mins);
            hash.add(hours * 60 + mins);
        }
        hash.sort(Comparator.naturalOrder());
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < hash.size() - 1; i++) {
            res = Math.min(res, hash.get(i + 1) - hash.get(i));
        }
        return res;
    }
}
