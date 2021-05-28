package binarysearch.weekly_37;

import java.util.ArrayList;
import java.util.List;

public class P_3 {

    public int solve(int[][] fruits, int k, int capacity) {
        final List<int[]> list = new ArrayList<>();
        for (int[] fruit : fruits) {
            final int cost = fruit[0];
            final int size = fruit[1];
            final int total = fruit[2];
            final int maxTake = Math.min(capacity / size, total);
            if (maxTake == 0) {
                continue;
            }
            list.add(new int[] { maxTake * cost, maxTake * size, total / maxTake });
            final int r = total % maxTake;
            if (r > 0) {
                list.add(new int[] { r * cost, r * size, 1 });
            }
        }
        list.sort((a, b) -> b[1] == a[1] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        int res = 0;
        for (int[] fruit : list) {
            final int qty = fruit[2];
            final int cost = fruit[0];
            final int maxTake = Math.min(k, qty);
            res += maxTake * cost;
            k -= maxTake;
        }
        return res;
    }
}
