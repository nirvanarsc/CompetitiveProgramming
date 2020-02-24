package weekly_contests.weekly_155;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P_1203 {

    public static final int[] EMPTY = new int[0];

    @SuppressWarnings("unchecked")
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        final int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        final int[] groupDeg = new int[m];
        final int[] itemDeg = new int[n];
        final List<Integer>[] groupAdj = new List[m];
        final List<Integer>[] itemAdj = new List[n];
        final List<Integer>[] groupItems = new List[m];
        for (int i = 0; i < n; i++) { itemAdj[i] = new ArrayList<>(); }
        for (int i = 0; i < m; i++) { groupAdj[i] = new ArrayList<>(); }
        for (int i = 0; i < m; i++) { groupItems[i] = new ArrayList<>(); }
        for (int i = 0; i < n; i++) { groupItems[group[i]].add(i); }
        for (int i = 0; i < n; i++) {
            for (int x : beforeItems.get(i)) {
                if (group[x] == group[i]) {
                    itemDeg[i]++;
                    itemAdj[x].add(i);
                } else {
                    groupDeg[group[i]]++;
                    groupAdj[group[x]].add(group[i]);
                }
            }
        }

        final Deque<Integer> groupQ = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (groupDeg[i] == 0) {
                groupQ.add(i);
            }
        }
        int idx = 0;
        while (!groupQ.isEmpty()) {
            final int u = groupQ.poll();
            final Deque<Integer> itemQ = new ArrayDeque<>();
            for (int x : groupItems[u]) {
                if (itemDeg[x] == 0) {
                    itemQ.add(x);
                }
            }
            while (!itemQ.isEmpty()) {
                final int item = itemQ.poll();
                ans[idx++] = item;
                for (int y : itemAdj[item]) {
                    itemDeg[y]--;
                    if (itemDeg[y] == 0) {
                        itemQ.add(y);
                    }
                }
            }
            for (int v : groupAdj[u]) {
                groupDeg[v]--;
                if (groupDeg[v] == 0) {
                    groupQ.add(v);
                }
            }
        }
        return idx < n ? EMPTY : ans;
    }
}
