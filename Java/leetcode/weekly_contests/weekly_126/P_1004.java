package leetcode.weekly_contests.weekly_126;

public class P_1004 {

    public int longestOnes(int[] A, int K) {
        int i = 0;
        int res = 0;
        for (int j = 0; j < A.length; j++) {
            if (A[j] == 0) {
                K--;
            }
            while (K < 0) {
                if (A[i++] == 0) {
                    K++;
                }
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
