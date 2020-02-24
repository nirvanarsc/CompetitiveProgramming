package weekly_contests.weekly_165;

public class P_1278 {

    public int palindromePartition(String s, int k) {
        return help(s, k, 0, new Integer[s.length()][k + 1]);
    }

    private static int help(String s, int k, int left, Integer[][] memo) {
        if (s.length() - left <= k) {
            return 0;
        }
        if (memo[left][k] != null) {
            return memo[left][k];
        }
        int res = Integer.MAX_VALUE;
        final int right = (k == 1) ? s.length() - 1 : left;
        for (int i = right; i <= s.length() - k; i++) {
            int l = left, r = i;
            int count = 0;
            while (l < r) {
                if (s.charAt(l++) != s.charAt(r--)) {
                    count++;
                }
            }
            if (count <= res) {
                res = Math.min(res, count + help(s, k - 1, i + 1, memo));
            }
        }
        return memo[left][k] = res;
    }
}
