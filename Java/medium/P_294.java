package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_294 {

    public boolean canWin(String s) {
        return canWin(s, new HashMap<>());
    }

    public boolean canWin(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                final String next = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(next, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

    public boolean canWinSG(String s) {
        final List<Integer> initialState = new ArrayList<>();
        int currL = 0, maxL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                currL++;
            }
            if (i + 1 == s.length() || s.charAt(i) == '-') {
                if (currL >= 2) {
                    initialState.add(currL);
                }
                maxL = Math.max(maxL, currL);
                currL = 0;
            }
        }
        final int[] grundy = new int[maxL + 1];
        for (int len = 2; len <= maxL; len++) {
            final Set<Integer> next = new HashSet<>();
            for (int currGame = 0; currGame < len / 2; ++currGame) {
                next.add(grundy[currGame] ^ grundy[len - currGame - 2]);
            }
            grundy[len] = getMex(next);
        }
        int g_final = 0;
        for (int idx : initialState) {
            g_final ^= grundy[idx];
        }
        return g_final != 0;
    }

    private static int getMex(Set<Integer> set) {
        final int m = set.size();
        for (int i = 0; i < m; ++i) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return m;
    }
}
