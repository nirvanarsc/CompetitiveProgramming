package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_118 {

    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            final List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int k = 1; k < i; k++) {
                curr.add(res.get(i - 1).get(k - 1) + res.get(i - 1).get(k));
            }
            curr.add(1);
            res.add(curr);
        }
        return res;
    }
}
