package leetcode.weekly_contests.weekly_127;

import java.util.Arrays;

public class P_1005 {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i = 0; i < A.length && K > 0; i++) {
            if (A[i] < 0) {
                A[i] = -A[i];
                K--;
            }
        }
        Arrays.sort(A);
        int res = 0;
        for (int num : A) {
            if (K > 0) {
                res += K % 2 == 0 ? num : -num;
                K = 0;
            } else {
                res += num;
            }
        }
        return res;
    }
}
