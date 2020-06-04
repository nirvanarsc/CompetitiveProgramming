package hard;

public class P_214 {

    public String shortestPalindrome(String s) {
        final StringBuilder reverse = new StringBuilder(s).reverse();
        final int[] kmp = kmp(s + '#' + reverse);
        return new StringBuilder(s.substring(kmp[kmp.length - 1])).reverse().append(s).toString();
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
}
