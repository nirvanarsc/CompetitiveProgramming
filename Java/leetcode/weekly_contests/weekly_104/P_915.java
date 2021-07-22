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

    public int partitionDisjointSpace(int[] nums) {
        final int n = nums.length;
        final int[] min = new int[n];
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(nums[i], min[i + 1]);
        }
        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, nums[i]);
            if (max <= min[i + 1]) {
                return i + 1;
            }
        }
        return n;
    }
}
