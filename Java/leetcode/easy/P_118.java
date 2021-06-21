package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_118 {

    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            final List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                final int l = j == 0 ? 0 : res.get(i - 1).get(j - 1);
                final int r = j == i ? 0 : res.get(i - 1).get(j);
                curr.add(l + r);
            }
            res.add(curr);
        }
        return res;
    }
}
