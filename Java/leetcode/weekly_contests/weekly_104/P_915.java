package leetcode.weekly_contests.weekly_104;

public class P_915 {

    @SuppressWarnings("MethodParameterNamingConvention")
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
}
