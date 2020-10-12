package leetcode.weekly_contests.weekly_114;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_954 {

    public boolean canReorderDoubled(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
        }
        Arrays.sort(A);
        final int n = A.length;
        final boolean[] paired = new boolean[n];
        for (int i = 0, j = 1; i < n; i++) {
            if (!paired[i]) {
                while (j < n && A[j] != 2 * A[i]) { j++; }
                if (j == n) { return false; }
                paired[j++] = true;
            }
        }
        return true;
    }

    public boolean canReorderDoubledTreeMap(int[] A) {
        final Map<Integer, Integer> count = new TreeMap<>();
        for (int num : A) {
            count.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            final int curr = entry.getKey();
            if (entry.getValue() != 0) {
                final int target = curr < 0 ? curr / 2 : curr * 2;
                if (curr < 0 && curr % 2 != 0 || entry.getValue() > count.getOrDefault(target, 0)) {
                    return false;
                }
                count.put(target, count.get(target) - entry.getValue());
            }
        }
        return true;
    }
}
