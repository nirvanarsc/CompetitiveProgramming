package leetcode.biweekly_contests.biweekly_62;

public class P_3 {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        final int n = answerKey.length();
        final int[] l = new int[n];
        final int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            if (answerKey.charAt(i) == 'T') {
                l[i] = 1;
            } else {
                r[i] = 1;
            }
        }
        return Math.max(longestOnes(l, k), longestOnes(r, k));
    }

    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            k -= nums[i] == 0 ? 1 : 0;
            while (k < 0) {
                k += nums[j++] == 0 ? 1 : 0;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
