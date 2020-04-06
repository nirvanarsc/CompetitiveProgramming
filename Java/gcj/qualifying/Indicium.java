package gcj.qualifying;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public final class Indicium {

    static class Pair {
        int n;
        int[] l;
        int[] r;

        Pair(int n, int[] l, int[] r) {
            this.n = n;
            this.l = l;
            this.r = r;
        }
    }

    static class Check {
        boolean canDo;
        List<Integer> res;

        Check(boolean canDo, List<Integer> res) {
            this.canDo = canDo;
            this.res = res;
        }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = in.nextInt();
            final int trace = in.nextInt();
            final Check dfs = dfs(new ArrayList<>(), n, trace, new int[n + 1]);
            if (!dfs.canDo) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            final int[][] m = new int[n][n];
            for (int[] r : m) {
                Arrays.fill(r, -1);
            }
            final List<Integer> d = dfs.res;
            for (int i = 0; i < n; i++) {
                m[i][i] = d.get(i);
            }
            final Set<Integer> present = new HashSet<>(d);
            for (int a = 1; a <= n; a++) {
                if (present.contains(a)) {
                    fill(n, m, a);
                }
            }
            for (int a = 1; a <= n; a++) {
                fill(n, m, a);
            }
            System.out.println("Case #" + x + ": " + "POSSIBLE");
            for (int[] row : m) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }

    private static void fill(int n, int[][] m, int a) {
        final List<List<Integer>> mat = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final List<Integer> can = new ArrayList<>(Collections.nCopies(n, 0));
            int found = -1;
            for (int j = 0; j < n; j++) {
                if (m[i][j] == a) { found = j; }
            }
            if (found >= 0) {
                can.set(found, 1);
            } else {
                for (int j = 0; j < n; j++) {
                    if (m[i][j] < 0) {
                        can.set(j, 1);
                    }
                }
            }
            mat.add(can);
        }
        for (int i = 0; i < n; i++) {
            m[i][BipartiteMatching(mat).l[i]] = a;
        }
    }

    private static Check dfs(List<Integer> v, int szneed, int totleft, int[] taken) {
        final Check empty = new Check(false, Collections.emptyList());
        if (totleft < szneed - v.size()) { return empty;}
        if (totleft > (szneed - v.size()) * szneed) {return empty;}
        if (v.size() == szneed) {
            for (int a = 1; a <= szneed; a++) {
                if (taken[a] == szneed - 1) {
                    return empty;
                }
            }
            return new Check(true, v);
        }
        for (int i = 1; i <= szneed; i++) {
            taken[i]++;
            v.add(i);
            final Check dfs = dfs(v, szneed, totleft - i, taken);
            if (dfs.canDo) { return dfs; }
            v.remove(v.size() - 1);
            taken[i]--;
        }
        return empty;
    }

    private static boolean FindMatch(int i, List<List<Integer>> w, int[] mr, int[] mc, boolean[] seen) {
        for (int j = 0; j < w.get(i).size(); j++) {
            if (w.get(i).get(j) == 1 && !seen[j]) {
                seen[j] = true;
                if (mc[j] < 0 || FindMatch(mc[j], w, mr, mc, seen)) {
                    mr[i] = j;
                    mc[j] = i;
                    return true;
                }
            }
        }
        return false;
    }

    private static Pair BipartiteMatching(List<List<Integer>> w) {
        final int[] mr = new int[w.size()];
        final int[] mc = new int[w.get(0).size()];
        Arrays.fill(mr, -1);
        Arrays.fill(mc, -1);

        int ct = 0;
        for (int i = 0; i < w.size(); i++) {
            boolean[] seen = new boolean[w.get(0).size()];
            if (FindMatch(i, w, mr, mc, seen)) {
                ct++;
            }
        }
        return new Pair(ct, mr, mc);
    }
}
