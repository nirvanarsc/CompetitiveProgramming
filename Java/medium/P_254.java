package medium;

import java.util.ArrayList;
import java.util.List;

public class P_254 {

    public List<List<Integer>> getFactors(int n) {
        final List<List<Integer>> res = new ArrayList<>();
        dfs(n, 2, res, new ArrayList<>());
        return res;
    }

    private static void dfs(int n, int start, List<List<Integer>> res, List<Integer> tmp) {
        for (int j = start; j * j <= n; j++) {
            if (n % j == 0) {
                tmp.add(j);
                dfs(n / j, j, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
        tmp.add(n);
        if (tmp.size() > 1) {
            res.add(new ArrayList<>(tmp));
        }
        tmp.remove(tmp.size() - 1);
    }
}
