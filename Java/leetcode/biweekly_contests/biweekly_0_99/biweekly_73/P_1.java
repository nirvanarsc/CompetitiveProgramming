package leetcode.biweekly_contests.biweekly_0_99.biweekly_73;

public class P_1 {

    public int mostFrequent(int[] nums, int key) {
        final int[] f = new int[1005];
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == key) {
                f[nums[i + 1]]++;
            }
        }
        for (int i = 0; i < 1005; i++) {
            if (f[res] < f[i]) {
                res = i;
            }
        }
        return res;
    }
}
