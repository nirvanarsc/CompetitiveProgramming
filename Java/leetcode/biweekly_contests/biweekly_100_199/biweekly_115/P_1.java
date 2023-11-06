package leetcode.biweekly_contests.biweekly_100_199.biweekly_115;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public List<Integer> lastVisitedIntegers(List<String> words) {
        final List<Integer> res = new ArrayList<>();
        final List<Integer> dq = new ArrayList<>();
        int prev = 0;
        for (String w : words) {
            if (!"prev".equals(w)) {
                dq.add(Integer.parseInt(w));
                prev = 0;
            } else {
                res.add(prev >= dq.size() ? -1 : dq.get(dq.size() - 1 - prev));
                prev++;
            }
        }
        return res;
    }
}
