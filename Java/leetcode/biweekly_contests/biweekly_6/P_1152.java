package leetcode.biweekly_contests.biweekly_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class P_1152 {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        final Map<String, TreeMap<Integer, String>> map = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            map.computeIfAbsent(username[i], v -> new TreeMap<>()).put(timestamp[i], website[i]);
        }
        final Map<String, Integer> freq = new HashMap<>();
        int maxCnt = 0;
        String res = "";
        for (Map.Entry<String, TreeMap<Integer, String>> e : map.entrySet()) {
            if (e.getValue().size() >= 3) {
                final List<String> strings = new ArrayList<>(e.getValue().values());
                final Set<String> single = new HashSet<>();
                for (int i = 0; i < strings.size() - 2; i++) {
                    for (int j = i + 1; j < strings.size() - 1; j++) {
                        for (int k = j + 1; k < strings.size(); k++) {
                            single.add(strings.get(i) + ',' + strings.get(j) + ',' + strings.get(k));
                        }
                    }
                }
                for (String str : single) {
                    freq.merge(str, 1, Integer::sum);
                    final int curCnt = freq.get(str);
                    if (curCnt > maxCnt | (curCnt == maxCnt && str.compareTo(res) < 0)) {
                        maxCnt = curCnt;
                        res = str;
                    }
                }
            }
        }
        return Arrays.asList(res.split(","));
    }
}
