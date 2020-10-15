package leetcode.weekly_contests.weekly_104;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_915 {

    public int partitionDisjoint(int[] A) {
        int localMax = A[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < A.length; i++) {
            if (localMax > A[i]) {
                localMax = max;
                partitionIdx = i;
            } else {
                max = Math.max(max, A[i]);
            }
        }
        return partitionIdx + 1;
    }

    public int partitionDisjointSpace(int[] A) {
        final int n = A.length;
        final int[] min = new int[n];
        int currMin = A[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            min[i] = Math.min(currMin, A[i]);
            currMin = min[i];
        }
        int max = A[0];
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, A[i]);
            if (max <= min[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }
}
