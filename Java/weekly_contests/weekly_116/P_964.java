package weekly_contests.weekly_116;

import java.util.HashMap;
import java.util.Map;

public class P_964 {

    public int leastOpsExpressTarget(int x, int target) {
        return recurse(x, target, new HashMap<>());
    }

    private static int recurse(int x, int target, Map<Integer, Integer> dp) {
        if (target == x) {
            return 0;
        }
        if (target < x) {
            return Math.min(target * 2 - 1, (x - target) * 2);
        }
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        final double l = Math.log(target) / Math.log(x);
        if (Math.abs(l - Math.round(l)) < 0.00001) {
            dp.put(target, (int) Math.round(l) - 1);
        } else {
            final int floor = (int) Math.floor(l);
            int result = floor + recurse(x, target - (int) Math.round(Math.pow(x, floor)), dp);
            if (target * 2 > Math.pow(x, floor + 1)) {
                result = Math.min(result, floor + 1 +
                                          recurse(x, (int) Math.round(Math.pow(x, floor + 1) - target), dp));
            }
            dp.put(target, result);
        }
        return dp.get(target);
    }
}
