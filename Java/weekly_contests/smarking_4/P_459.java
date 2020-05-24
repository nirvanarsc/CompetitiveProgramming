package weekly_contests.smarking_4;

public class P_459 {

    public boolean repeatedSubstringPatternKMP(String s) {
        final int n = s.length();
        final int[] prefixSuffix = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefixSuffix[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            prefixSuffix[i] = j;
        }
        final int length = prefixSuffix[n - 1];
        return length != 0 && n % (2 * length - n) == 0;

    }

    public boolean repeatedSubstringPattern(String s) {
        for (int i = s.length() / 2; i >= 1; i--) {
            int k = 0;
            boolean isRepeated = true;
            if (s.length() % i == 0) {
                for (int j = 0; j < s.length(); j++, k++) {
                    if (s.charAt(j) != s.charAt(k % i)) {
                        isRepeated = false;
                        break;
                    }
                }
                if (isRepeated) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean repeatedSubstringPatternConcatenate(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}
