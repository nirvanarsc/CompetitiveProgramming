package weekly_contests.weekly_184;

import java.util.LinkedList;

import utils.DataStructures.BIT;

public class P_1409 {

    public int[] processQueries(int[] queries, int m) {
        final int[] res = new int[queries.length];
        final int[] map = new int[2 * m + 1];
        final BIT bit = new BIT(2 * m + 1);
        for (int i = 1; i <= m; i++) {
            map[i] = i + m;
            bit.add(i + m, 1);
        }
        int i = 0;
        for (int q : queries) {
            res[i++] = bit.query(map[q] - 1);
            bit.add(map[q], -1);
            map[q] = m;
            bit.add(m, 1);
            m--;
        }
        return res;
    }

    public int[] processQueriesBF(int[] queries, int m) {
        final int[] res = new int[queries.length];
        final LinkedList<Integer> q = new LinkedList<>();
        for (int i = m; i >= 1; i--) {
            q.offerLast(i);
        }
        for (int i = 0; i < queries.length; i++) {
            final int idx = q.indexOf(queries[i]);
            res[i] = m - idx - 1;
            q.remove(idx);
            q.offerLast(queries[i]);
        }
        return res;
    }
}
