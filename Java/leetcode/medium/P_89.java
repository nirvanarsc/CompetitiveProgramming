package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_89 {

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>(Collections.singletonList(0));
        for (int i = 1; i <= n; i++) {
            final List<Integer> curr = new ArrayList<>(list);
            Collections.reverse(list);
            for (int t : list) {
                t |= 1 << (i - 1);
                curr.add(t);
            }
            list = curr;
        }

        return list;
    }

    public List<Integer> grayCodeBitwise(int n) {
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ i >> 1);
        }
        return res;
    }
}
