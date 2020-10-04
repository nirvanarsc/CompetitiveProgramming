package biweekly_contests.biweekly_36;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1604 {

    private static final int MOD = 1440;

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        final int n = keyName.length;
        final Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(keyName[i], v -> new ArrayList<>()).add(convert(keyTime[i]));
        }
        final List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            final List<Integer> times = entry.getValue();
            Collections.sort(times);
            boolean warned = false;
            for (int i = 0; i < times.size() - 2; i++) {
                final int a = times.get(i);
                final int b = times.get(i + 1);
                final int c = times.get(i + 2);
                int time = 0;
                time += (b - a + MOD) % MOD;
                time += (c - b + MOD) % MOD;
                if (time <= 60) {
                    warned = true;
                    break;
                }
            }
            if (warned) {
                res.add(entry.getKey());
            }
        }
        Collections.sort(res);
        return res;
    }

    private static int convert(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }
}
