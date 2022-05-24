package leetcode.weekly_contests.weekly_200_299.weekly_209;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_1610 {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        final List<Double> angles = new ArrayList<>();
        final int x = location.get(0);
        final int y = location.get(1);
        int equal = 0;
        for (List<Integer> p : points) {
            if (p.equals(location)) {
                equal++;
            } else {
                final int x1 = x - p.get(0);
                final int y1 = y - p.get(1);
                final double ll = Math.toDegrees(Math.atan2(x1, y1));
                angles.add(ll);
                angles.add(ll + 360);
            }
        }
        angles.sort(Comparator.naturalOrder());
        int j = 0;
        int res = 0;
        for (int i = 0; i < angles.size(); i++) {
            while (angles.get(i) - angles.get(j) > angle) {
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res + equal;
    }
}
