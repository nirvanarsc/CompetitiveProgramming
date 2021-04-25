package leetcode.weekly_contests.weekly_238;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P_1840 {

    public int maxBuilding(int n, int[][] restrictions) {
        final List<int[]> list = new ArrayList<>();
        list.add(new int[] { 1, 0 });
        list.add(new int[] { n, n });
        list.addAll(Arrays.asList(restrictions));
        list.sort(Comparator.comparingInt(a -> a[0]));
        pass(list);
        Collections.reverse(list);
        return pass(list);
    }

    private static int pass(List<int[]> list) {
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            final int l = list.get(i)[1];
            final int r = list.get(i + 1)[1];
            int h = l + Math.abs(list.get(i + 1)[0] - list.get(i)[0]);
            if (h > r) {
                h = (h + r) / 2;
            }
            res = Math.max(res, h);
            list.get(i + 1)[1] = Math.min(h, r);
        }
        return res;
    }
}
