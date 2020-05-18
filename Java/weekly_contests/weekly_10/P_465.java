package weekly_contests.weekly_10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P_465 {

    public int minTransfers(int[][] transactions) {
        final Map<Integer, Integer> personToDebt = new HashMap<>();
        for (int[] t : transactions) {
            personToDebt.merge(t[0], -t[2], Integer::sum);
            personToDebt.merge(t[1], t[2], Integer::sum);
        }
        final List<Integer> debts = personToDebt.values()
                                                .stream()
                                                .filter(d -> d != 0)
                                                .collect(Collectors.toList());
        return dfs(debts, 0);
    }

    private static int dfs(List<Integer> debts, int start) {
        while (start < debts.size() && debts.get(start) == 0) {
            start++;
        }
        if (start == debts.size()) {
            return 0;
        }
        int ret = Integer.MAX_VALUE;
        for (int i = start + 1; i < debts.size(); i++) {
            if (debts.get(start) * debts.get(i) < 0) {
                debts.set(i, debts.get(i) + debts.get(start));
                ret = Math.min(ret, 1 + dfs(debts, start + 1));
                debts.set(i, debts.get(i) - debts.get(start));
            }
        }
        return ret;
    }
}
