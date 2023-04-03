package leetcode.biweekly_contests.biweekly_100_199.biweekly_101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_3 {

    public long makeSubKSumEqual(int[] arr, int k) {
        final int n = arr.length;
        long res = 0;
        for (int i = 0; i < k; i++) {
            final List<Integer> cycle = new ArrayList<>();
            for (int j = i; arr[j] != 0; j = (j + k) % n) {
                cycle.add(arr[j]);
                arr[j] = 0;
            }
            if (!cycle.isEmpty()) {
                Collections.sort(cycle);
                final int median = cycle.get(cycle.size() / 2);
                for (int num : cycle) {
                    res += Math.abs(num - median);
                }
            }
        }
        return res;
    }
}
