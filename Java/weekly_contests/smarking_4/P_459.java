package weekly_contests.smarking_4;

public class P_459 {

    public boolean repeatedSubstringPattern(String s) {
        final int longestPrefix = kmp(s)[s.length() - 1];
        return longestPrefix > 0 && s.length() % (s.length() - longestPrefix) == 0;
    }

    private static int[] kmp(String s) {
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
        return prefixSuffix;
    }

    public boolean repeatedSubstringPatternConcatenate(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}
