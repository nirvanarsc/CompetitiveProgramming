package leetcode.weekly_contests.weekly_103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_910 {

    public int smallestRangeIIDp(int[] A, int K) {
        final int n = A.length;
        Arrays.sort(A);
        int res = A[n - 1] - A[0];
        for (int i = 1; i < n; i++) {
            final int currMin = Math.min(A[0] + K, A[i] - K);
            final int currMax = Math.max(A[i - 1] + K, A[n - 1] - K);
            res = Math.min(res, Math.abs(currMax - currMin));
        }
        return res;
    }

    public int smallestRangeII(int[] A, int K) {
        final int[] freq = new int[(int) (1e4 + 5)];
        final List<int[]> list = new ArrayList<>();
        for (int num : A) {
            freq[num]++;
            list.add(new int[] { num - K, num });
            list.add(new int[] { num + K, num });
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        int window = A.length;
        int j = 0;
        int res = (int) 1e9;
        for (int i = 0; i < list.size(); i++) {
            if (freq[list.get(i)[1]]-- > 0) {
                window--;
            }
            while (window == 0) {
                res = Math.min(res, list.get(i)[0] - list.get(j)[0]);
                if (++freq[list.get(j++)[1]] == 1) {
                    window++;
                }
            }
        }
        return res;
    }
}
