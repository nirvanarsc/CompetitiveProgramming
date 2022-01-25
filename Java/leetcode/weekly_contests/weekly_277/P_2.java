package leetcode.weekly_contests.weekly_277;

public class P_2 {

    public int[] rearrangeArray(int[] nums) {
        final int n = nums.length;
        final int[] res = new int[n];
        final int[] l = new int[n / 2];
        final int[] r = new int[n / 2];
        int lIdx = 0;
        int rIdx = 0;
        for (int num : nums) {
            if (num > 0) {
                l[lIdx++] = num;
            } else {
                r[rIdx++] = num;
            }
        }
        lIdx = 0;
        rIdx = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res[i] = l[lIdx++];
            } else {
                res[i] = r[rIdx++];
            }
        }
        return res;
    }
}
