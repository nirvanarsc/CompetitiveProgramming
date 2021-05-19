package binarysearch.weekly_44;

import java.util.ArrayList;
import java.util.List;

public class P_2 {

    public int[] solve(String s) {
        final List<Integer> res = new ArrayList<>();
        int d = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (d == res.size()) {
                    res.add(0);
                }
                d++;
            } else if (c == ')') {
                d--;
            } else {
                res.set(d - 1, res.get(d - 1) + 1);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
