package weekly_contests.weekly_40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_638 {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return recurse(price, special, needs, new HashMap<>());
    }

    private static int recurse(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
                               Map<Integer, Integer> dp) {
        if (needs.stream().allMatch(i -> i == 0)) {
            return 0;
        }
        final Integer key = needs.hashCode();
        if (dp.containsKey(key)) {
            dp.get(key);
        }
        int res = 0;
        for (int i = 0; i < needs.size(); i++) {
            res += price.get(i) * needs.get(i);
        }
        for (List<Integer> s : special) {
            final List<Integer> clone = new ArrayList<>(needs);
            boolean add = true;
            for (int i = 0; i < s.size() - 1; i++) {
                clone.set(i, clone.get(i) - s.get(i));
                if (clone.get(i) < 0) {
                    add = false;
                }
            }
            if (add) {
                res = Math.min(res, s.get(s.size() - 1) + recurse(price, special, clone, dp));
            }
        }
        dp.put(key, res);
        return res;
    }
}
