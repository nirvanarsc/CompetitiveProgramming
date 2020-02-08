package weekly_160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_1238 {

    public List<Integer> circularPermutationOptimized(int n, int start) {
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(start ^ i ^ i >> 1);
        }
        return res;
    }

    public List<Integer> circularPermutation(int n, int start) {
        final List<Integer> grayCode = getGrayCode(n);
        final List<Integer> res = new ArrayList<>();
        final int idx = grayCode.indexOf(start);
        for (int i = idx; i < idx + grayCode.size(); i++) {
            res.add(grayCode.get(i % grayCode.size()));
        }
        return res;
    }

    private static List<Integer> getGrayCode(int n) {
        List<Integer> res = Arrays.asList(1, 0);
        for (int i = 1; i < n; i++) {
            final List<Integer> next = new ArrayList<>();
            for (int num : res) {
                next.add(1 << i | num);
            }
            Collections.reverse(res);
            next.addAll(res);
            res = next;
        }
        return res;
    }
}
