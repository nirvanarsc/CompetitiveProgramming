package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_89 {

    public List<Integer> grayCode(int n) {
        final List<Integer> res = new ArrayList<>(Collections.singletonList(0));
        for (int i = 0; i < n; i++) {
            final int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add((1 << i) | res.get(j));
            }
        }
        return res;
    }

    public List<Integer> grayCodeBitwise(int n) {
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ i >> 1);
        }
        return res;
    }
}
