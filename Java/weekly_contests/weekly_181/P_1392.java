package weekly_contests.weekly_181;

public class P_1392 {

    public String longestPrefixSuffix(String s) {
        final int n = s.length();
        final int[] prefixSuffix = new int[n];

        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefixSuffix[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            prefixSuffix[i] = j;
        }

        return s.substring(0, prefixSuffix[n - 1]);
    }
}
