package easy;

public class P_28 {

    // O(n+m)
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        final int[] prefixSuffix = kmp(needle);
        for (int i = 0, j = 0; i < haystack.length() && j < needle.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = prefixSuffix[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
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

    // Expected O(n+m), worst-case O(n*m)
    public int strStrRabinKarp(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        final int BASE = 26;
        int tHash = 0, sHash = 0;
        int powerS = 1;
        for (int i = 0; i < needle.length(); i++) {
            powerS = i > 0 ? powerS * BASE : 1;
            tHash = tHash * BASE + haystack.charAt(i);
            sHash = sHash * BASE + needle.charAt(i);
        }
        for (int i = needle.length(); i < haystack.length(); i++) {
            if (tHash == sHash && haystack.startsWith(needle, i - needle.length())) {
                return i - needle.length();
            }
            tHash -= haystack.charAt(i - needle.length()) * powerS;
            tHash = tHash * BASE + haystack.charAt(i);
        }
        if (tHash == sHash && haystack.endsWith(needle)) {
            return haystack.length() - needle.length();
        }
        return -1;
    }
}
