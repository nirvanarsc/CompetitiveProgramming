package weekly_contests.weekly_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_481 {

    public int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        final List<Integer> s = new ArrayList<>(Arrays.asList(1, 2, 2));
        int res = 1;
        for (int idx = 2; s.size() < n; idx++) {
            final int prev = s.get(s.size() - 1);
            for (int t = 0; t < s.get(idx); t++) {
                if (prev == 2) {
                    s.add(1);
                    res++;
                    if (s.size() == n) {
                        return res;
                    }
                } else {
                    s.add(2);
                }
            }
        }
        return res;
    }
}
