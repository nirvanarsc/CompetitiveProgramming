package gcj.round1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public final class P_2 {

    private static final int[][] DIRS = { { -1, -1 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final List<List<Integer>> triangle = generate(30);
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = in.nextInt();
            final List<List<Integer>> path = new ArrayList<>(Collections.singleton(Arrays.asList(1, 1)));
            final Set<String> visited = new HashSet<>(Collections.singleton("0,0"));
            dfs(0, 0, 1, n, path, triangle, visited);
            System.out.println("Case #" + x + ':');
            for (List<Integer> p : path) {
                System.out.println(p.get(0) + " " + p.get(1));
            }
        }
    }

    private static boolean dfs(int r, int k, long sum, int target, List<List<Integer>> path,
                               List<List<Integer>> triangle, Set<String> visited) {
        if (sum == target) {
            return true;
        }
        for (int[] dir : DIRS) {
            final int nr = r + dir[0];
            final int nk = k + dir[1];
            if (0 <= nr && nr < 30 && 0 <= nk && nk < triangle.get(nr).size()) {
                final long nd = sum + triangle.get(nr).get(nk);
                final String key = nr + "," + nk;
                if (nd <= target && path.size() <= 500 && !visited.contains(key)) {
                    visited.add(key);
                    path.add(Arrays.asList(nr + 1, nk + 1));
                    if (dfs(nr, nk, nd, target, path, triangle, visited)) {
                        return true;
                    }
                    visited.remove(key);
                    path.remove(path.size() - 1);
                }
            }
        }
        return false;
    }

    public static List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            final List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int k = 1; k < i; k++) {
                curr.add(res.get(i - 1).get(k - 1) + res.get(i - 1).get(k));
            }
            curr.add(1);
            res.add(curr);
        }
        return res;
    }
}
