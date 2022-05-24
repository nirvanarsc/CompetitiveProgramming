package leetcode.weekly_contests.weekly_100_199.weekly_123;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_992 {

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMost(A, K) - atMost(A, K - 1);
    }

    public int atMost(int[] A, int K) {
        int res = 0, i = 0;
        final int[] map = new int[A.length + 1];
        for (int j = 0; j < A.length; j++) {
            if (map[A[j]]++ == 0) {
                K--;
            }
            while (K < 0) {
                if (--map[A[i++]] == 0) {
                    K++;
                }
            }
            res += j - i + 1;
        }
        return res;
    }
}
