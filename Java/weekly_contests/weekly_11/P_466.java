package weekly_contests.weekly_11;

public class P_466 {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        final int n = 105;
        final int[] dp = new int[n];
        final int[] next = new int[n];
        final int l1 = s1.length();
        final int l2 = s2.length();
        for (int i = 0; i < l2; ++i) {
            int cur = i;
            for (int j = 0; j < l1; ++j) {
                if (s1.charAt(j) == s2.charAt(cur % l2)) {
                    ++cur;
                }
            }
            dp[i] = cur / l2;
            next[i] = cur % l2;
        }
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < n1; ++i) {
            ans += dp[cur];
            cur = next[cur];
        }
        return ans / n2;
    }

    public int getMaxRepetitionsBF(String s1, int n1, String s2, int n2) {
        final char[] array1 = s1.toCharArray();
        final char[] array2 = s2.toCharArray();
        int count1 = 0, count2 = 0, i = 0, j = 0;
        while (count1 < n1) {
            if (array1[i] == array2[j]) {
                j++;
                if (j == array2.length) {
                    j = 0;
                    count2++;
                }
            }
            i++;
            if (i == array1.length) {
                i = 0;
                count1++;
            }
        }
        return count2 / n2;
    }
}
