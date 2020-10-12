package leetcode.weekly_contests.weekly_209;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_1610 {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        final List<Double> angles = new ArrayList<>();
        int equal = 0;
        for (List<Integer> point : points) {
            if (point.equals(location)) {
                equal++;
            } else {
                double ang = Math.toDegrees(Math.atan2(point.get(0) - location.get(0),
                                                       point.get(1) - location.get(1)));
                if (ang < 0) {
                    ang += 360;
                }
                angles.add(ang);
                angles.add(ang + 360);
            }
        }
        Collections.sort(angles);
        int res = 0;
        int j = 0;
        for (int i = 0; i < angles.size(); i++) {
            while (angles.get(i) - angles.get(j) > angle) {
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res + equal;
    }
}
