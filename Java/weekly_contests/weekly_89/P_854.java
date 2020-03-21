package weekly_contests.weekly_89;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_854 {

    public int kSimilarity(String A, String B) {
        final Deque<String> queue = new ArrayDeque<>(Collections.singleton(A));
        final Map<String, Integer> dist = new HashMap<>(Collections.singletonMap(A, 0));
        while (!queue.isEmpty()) {
            final String S = queue.poll();
            if (S.equals(B)) {
                return dist.get(S);
            }
            for (String T : neighbours(S, B)) {
                if (!dist.containsKey(T)) {
                    dist.put(T, dist.get(S) + 1);
                    queue.offer(T);
                }
            }
        }
        return -1;
    }

    public List<String> neighbours(String S, String target) {
        final List<String> ans = new ArrayList<>();
        int i = 0;
        while (S.charAt(i) == target.charAt(i)) {
            i++;
        }
        final char[] T = S.toCharArray();
        for (int j = i + 1; j < S.length(); ++j) {
            if (S.charAt(j) == target.charAt(i)) {
                swap(T, i, j);
                ans.add(new String(T));
                swap(T, i, j);
            }
        }
        return ans;
    }

    public void swap(char[] T, int i, int j) {
        final char tmp = T[i];
        T[i] = T[j];
        T[j] = tmp;
    }
}
