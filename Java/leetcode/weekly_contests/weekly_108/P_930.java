package leetcode.weekly_contests.weekly_108;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_930 {

    public int numSubarraysWithSum(int[] A, int S) {
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, 1));
        int curr = 0, res = 0;
        for (int num : A) {
            curr += num;
            res += map.getOrDefault(curr - S, 0);
            map.merge(curr, 1, Integer::sum);
        }
        return res;
    }

    public int numSubarraysWithSumSW(int[] A, int S) {
        return atMost(A, S) - atMost(A, S - 1);
    }

    public int atMost(int[] A, int S) {
        if (S < 0) { return 0; }
        int res = 0, i = 0;
        for (int j = 0; j < A.length; j++) {
            S -= A[j];
            while (S < 0) {
                S += A[i++];
            }
            res += j - i + 1;
        }
        return res;
    }
}
