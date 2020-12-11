package atcoder.beginner_100_199.beginner_170;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public final class E {

    public static void main(String[] args) {
        final int MAX = (int) 2e5;
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int q = in.nextInt();
        in.nextLine();
        final Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
        final SegmentTree st = new SegmentTree(MAX);
        final int[] rating = new int[n + 1];
        final int[] garden = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            rating[i] = in.nextInt();
            garden[i] = in.nextInt();
            map.computeIfAbsent(garden[i], v -> new TreeMap<>()).merge(rating[i], 1, Integer::sum);
        }
        for (int i = 1; i <= MAX; i++) {
            if (map.containsKey(i)) {
                st.update(1, 1, MAX, i, map.get(i).lastKey());
            }
        }
        for (int i = 0; i < q; i++) {
            final int id = in.nextInt();
            final int newGarden = in.nextInt();
            map.get(garden[id]).merge(rating[id], -1, Integer::sum);
            if (map.get(garden[id]).get(rating[id]) == 0) {
                map.get(garden[id]).remove(rating[id]);
            }
            if (!map.get(garden[id]).isEmpty()) {
                st.update(1, 1, MAX, garden[id], map.get(garden[id]).lastKey());
            } else {
                st.update(1, 1, MAX, garden[id], 1 << 30);
            }
            map.computeIfAbsent(newGarden, v -> new TreeMap<>()).merge(rating[id], 1, Integer::sum);
            st.update(1, 1, MAX, newGarden, map.get(newGarden).lastKey());
            garden[id] = newGarden;
            System.out.println(st.query(1, 1, MAX, 1, MAX));
        }
    }

    private static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
            build(1, 1, n);
        }

        void build(int ti, int tl, int tr) {
            if (tl == tr) {
                tree[ti] = 1 << 30;
            } else {
                final int tm = tl + tr >>> 1;
                build(2 * ti, tl, tm);
                build(2 * ti + 1, tm + 1, tr);
                tree[ti] = Math.min(tree[2 * ti], tree[2 * ti + 1]);
            }
        }

        void update(int ti, int tl, int tr, int pos, int val) {
            if (tl == tr) {
                tree[ti] = val;
                return;
            }
            final int tm = tl + tr >>> 1;
            if (pos <= tm) {
                update(2 * ti, tl, tm, pos, val);
            } else {
                update(2 * ti + 1, tm + 1, tr, pos, val);
            }
            tree[ti] = Math.min(tree[2 * ti], tree[2 * ti + 1]);
        }

        int query(int ti, int tl, int tr, int l, int r) {
            if (l > tr || r < tl) { return 1 << 30; }
            if (tl >= l && tr <= r) { return tree[ti]; }
            final int tm = tl + tr >>> 1;
            final int q1 = query(2 * ti, tl, tm, l, r);
            final int q2 = query(2 * ti + 1, tm + 1, tr, l, r);
            return Math.min(q1, q2);
        }
    }
}
