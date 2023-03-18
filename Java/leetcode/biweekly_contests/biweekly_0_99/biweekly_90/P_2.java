package leetcode.biweekly_contests.biweekly_0_99.biweekly_90;

import java.util.ArrayList;
import java.util.List;

public class P_2 {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        final List<String> res = new ArrayList<>();
        final int n = queries[0].length();
        outer:
        for (String q : queries) {
            for (String d : dictionary) {
                int diff = 0;
                for (int i = 0; i < n; i++) {
                    if (q.charAt(i) != d.charAt(i)) {
                        diff++;
                    }
                }
                if (diff < 3) {
                    res.add(q);
                    continue outer;
                }
            }
        }
        return res;
    }
}
