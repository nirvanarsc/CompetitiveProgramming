package leetcode.biweekly_contests.biweekly_100_199.biweekly_106;

public class P_2 {

    public int longestSemiRepetitiveSubstring(String s) {
        final char[] w = s.toCharArray();
        final int n = s.length();
        final int[] arr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = w[i + 1] == w[i] ? 1 : 0;
        }
        int res = 0;
        int j = 0;
        int curr = 0;
        for (int i = 0; i < n - 1; i++) {
            curr += arr[i];
            while (curr > 1) {
                curr -= arr[j++];
            }
            res = Math.max(res, i - j + 1);
        }
        return 1 + res;
    }
}
