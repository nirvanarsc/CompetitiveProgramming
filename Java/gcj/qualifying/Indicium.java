package gcj.qualifying;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class Indicium {

    static class Pair<T1, T2> {
        T1 left;
        T2 right;

        Pair(T1 left, T2 right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = in.nextInt();
            final int trace = in.nextInt();
            final Pair<Boolean, List<Integer>> dfs = dfs(new ArrayList<>(), n, trace, new int[n + 1]);
            if (!dfs.left) {
                System.out.println("Case #" + x + ": IMPOSSIBLE");
                continue;
            }
            final int[][] m = new int[n][n];
            for (int[] r : m) {
                Arrays.fill(r, -1);
            }
            final List<Integer> d = dfs.right;
            for (int i = 0; i < n; i++) {
                m[i][i] = d.get(i);
            }
            for (int a : d) {
                fill(n, m, a);
            }
            for (int a = 1; a <= n; a++) {
                fill(n, m, a);
            }
            System.out.println("Case #" + x + ": POSSIBLE");
            for (int[] row : m) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }

    private static void fill(int n, int[][] ret, int a) {
        final List<List<Integer>> m = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final List<Integer> can = new ArrayList<>(Collections.nCopies(n, 0));
            int found = -1;
            for (int j = 0; j < n; j++) {
                if (ret[i][j] == a) {
                    found = j;
                }
            }
            if (found >= 0) {
                can.set(found, 1);
            } else {
                for (int j = 0; j < n; j++) {
                    if (ret[i][j] < 0) {
                        can.set(j, 1);
                    }
                }
            }
            m.add(can);
        }
        final Pair<Integer[], Integer[]> matching = BipartiteMatching(m, n);
        for (int i = 0; i < n; i++) {
            ret[i][matching.left[i]] = a;
        }
    }

    private static Pair<Boolean, List<Integer>> dfs(List<Integer> v, int need, int target, int[] taken) {
        final Pair<Boolean, List<Integer>> empty = new Pair<>(false, Collections.emptyList());
        if (target < need - v.size() || (target > (need - v.size()) * need)) {
            return empty;
        }
        if (v.size() == need) {
            for (int a = 1; a <= need; a++) {
                if (taken[a] == need - 1) {
                    return empty;
                }
            }
            return new Pair<>(true, v);
        }
        for (int i = 1; i <= need; i++) {
            taken[i]++;
            v.add(i);
            final Pair<Boolean, List<Integer>> dfs = dfs(v, need, target - i, taken);
            if (dfs.left) {
                return dfs;
            }
            v.remove(v.size() - 1);
            taken[i]--;
        }
        return empty;
    }

    private static boolean FindMatch(int i, List<List<Integer>> w, Integer[] mr, Integer[] mc, boolean[] seen) {
        for (int j = 0; j < w.size(); j++) {
            if (w.get(i).get(j) == 1 && !seen[j]) {
                seen[j] = true;
                if (mc[j] == null || FindMatch(mc[j], w, mr, mc, seen)) {
                    mr[i] = j;
                    mc[j] = i;
                    return true;
                }
            }
        }
        return false;
    }

    private static Pair<Integer[], Integer[]> BipartiteMatching(List<List<Integer>> w, int n) {
        final Integer[] row = new Integer[n];
        final Integer[] col = new Integer[n];

        for (int i = 0; i < w.size(); i++) {
            FindMatch(i, w, row, col, new boolean[n]);
        }

        return new Pair<>(row, col);
    }
}
