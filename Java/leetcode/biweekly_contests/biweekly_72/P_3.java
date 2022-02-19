package leetcode.biweekly_contests.biweekly_72;

import java.util.ArrayList;
import java.util.List;

public class P_3 {

    public List<Long> maximumEvenSplit(long finalSum) {
        final List<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return res;
        }
        long s = finalSum;
        for (long h = 2; s >= h; h += 2) {
            res.add(h);
            s -= h;
        }
        res.set(res.size() - 1, res.get(res.size() - 1) + s);
        return res;
    }
}
