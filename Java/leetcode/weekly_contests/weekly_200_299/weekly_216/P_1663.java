package leetcode.weekly_contests.weekly_200_299.weekly_216;

public class P_1663 {

    public String getSmallestString(int n, int k) {
        final char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            final int curr = Math.max(1, k - (n - 1 - i) * 26);
            res[i] = (char) (curr + 'a' - 1);
            k -= curr;
        }
        return new String(res);
    }
}
