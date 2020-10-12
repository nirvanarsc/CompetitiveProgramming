package leetcode.weekly_contests.weekly_84;

import java.util.Map;
import java.util.TreeMap;

public class P_833 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        final StringBuilder sb = new StringBuilder();
        final Map<Integer, String[]> map = new TreeMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], new String[] { sources[i], targets[i] });
        }
        int i = 0;
        for (Map.Entry<Integer, String[]> entry : map.entrySet()) {
            final int idx = entry.getKey();
            final String[] curr = entry.getValue();
            if (i < idx) {
                sb.append(S, i, idx);
                i = idx;
            }
            if (S.startsWith(curr[0], idx)) {
                sb.append(curr[1]);
                i += curr[0].length();
            }
        }
        return sb.append(S.substring(i)).toString();
    }
}
