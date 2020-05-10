package weekly_contests.weekly_188;

import java.util.ArrayList;
import java.util.List;

public class P_1441 {

    public List<String> buildArray(int[] target, int n) {
        final List<String> res = new ArrayList<>();
        int j = 0;
        for (int k = 1; k <= n; k++) {
            if (j == target.length) { break; }
            if (target[j] == k) {
                res.add("Push");
                j++;
            } else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }
}


