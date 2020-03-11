package weekly_contests.weekly_106;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_923 {

    private static final int MOD = (int) (1e9 + 7);

    @SuppressWarnings("MethodParameterNamingConvention")
    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int num : A) {
            freq.merge(num, 1, Integer::sum);
        }
        long res = 0;
        for (int i = 0; i < A.length - 2; i++) {
            if (i > 0 && A[i - 1] == A[i]) { continue; }
            int low = i + 1;
            int high = A.length - 1;
            while (low < high) {
                if (A[low] + A[high] + A[i] == target) {
                    res = (res + getComb(A[i], A[low], A[high], freq)) % MOD;
                    while (low < high && A[low] == A[low + 1]) { low++; }
                    while (low < high && A[high] == A[high - 1]) { high--; }
                    low++;
                    high--;
                } else if (A[low] + A[high] + A[i] < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return (int) res;
    }

    private static long getComb(int a, int b, int c, Map<Integer, Integer> freq) {
        if (a == b && b == c) {
            return Long.valueOf(freq.get(a)) * (freq.get(a) - 1) * (freq.get(a) - 2) / 6;
        }
        if (a == b) {
            return Long.valueOf(freq.get(a)) * (freq.get(b) - 1) * freq.get(c) / 2;
        }
        if (b == c) {
            return Long.valueOf(freq.get(a)) * (freq.get(b) - 1) * freq.get(c) / 2;
        }
        return Long.valueOf(freq.get(a)) * freq.get(b) * freq.get(c);
    }
}
