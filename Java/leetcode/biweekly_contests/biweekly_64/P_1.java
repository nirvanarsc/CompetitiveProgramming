package leetcode.biweekly_contests.biweekly_64;

import java.util.HashMap;
import java.util.Map;

public class P_1 {

    public String kthDistinct(String[] arr, int k) {
        final Map<String, Integer> f = new HashMap<>();
        for (String s : arr) {
            f.merge(s, 1, Integer::sum);
        }
        for (String s : arr) {
            if (f.get(s) == 1) {
                if (--k == 0) {
                    return s;
                }
            }
        }
        return "";
    }
}
