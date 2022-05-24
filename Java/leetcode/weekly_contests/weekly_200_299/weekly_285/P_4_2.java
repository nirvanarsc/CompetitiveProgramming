package leetcode.weekly_contests.weekly_200_299.weekly_285;

import java.util.TreeMap;
import java.util.TreeSet;

@SuppressWarnings("ConstantConditions")
public class P_4_2 {

    static TreeMap<Integer, Integer> tm;
    static TreeSet<Integer> ts;
    static char[] w;
    static int n;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        w = s.toCharArray();
        n = s.length();
        tm = new TreeMap<>();
        ts = new TreeSet<>();
        ts.add(n);
        for (int i = 0; i < n; i++) {
            ts.add(i);
            int j = i;
            while (j < n && w[j] == w[i]) {
                j++;
            }
            tm.merge(j - i, 1, Integer::sum);
            i = j - 1;
        }
        final int q = queryCharacters.length();
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final char c = queryCharacters.charAt(i);
            final int u = queryIndices[i];
            if (w[u] == c) {
                res[i] = tm.lastKey();
                continue;
            }
            final int l = ts.floor(u);
            final int r = ts.higher(u) - 1;
            int updated = r - l + 1;
            if (u == l && u == r) {
                updated += addL(c, u, l);
                updated += addR(c, u, r);
                f(updated, 1);
            } else if (u == l) {
                int curr = 1;
                curr += addL(c, u, l);
                f(curr, 1);
                f(updated - 1, 1);
                f(updated, -1);
                ts.add(u + 1);
            } else if (u == r) {
                int curr = 1;
                curr += addR(c, u, r);
                f(curr, 1);
                f(updated - 1, 1);
                f(updated, -1);
                ts.add(u);
            } else {
                ts.add(u);
                ts.add(u + 1);
                f(u - l, 1);
                f(1, 1);
                f(r - u, 1);
                f(updated, -1);
            }
            w[u] = c;
            res[i] = tm.lastKey();
        }
        return res;
    }

    private static int addR(char c, int u, int r) {
        if (u < (n - 1) && w[u + 1] == c) {
            ts.remove(r + 1);
            r = ts.higher(u + 1) - 1;
            f(r - u, -1);
        }
        return r - u;
    }

    private static int addL(char c, int u, int l) {
        if (u > 0 && w[u - 1] == c) {
            ts.remove(l);
            l = ts.floor(u - 1);
            f(u - l, -1);
        }
        return u - l;
    }

    private static void f(int u, int v) {
        final int curr = tm.merge(u, v, Integer::sum);
        if (curr == 0) {
            tm.remove(u);
        }
    }
}
