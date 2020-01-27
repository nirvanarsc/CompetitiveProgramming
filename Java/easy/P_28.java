package easy;

public class P_28 {

    // O(n+m)
    public int strStrKMP(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        final int[] prefixSuffix = new int[needle.length()];

        for (int i = 1, j = 0; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = prefixSuffix[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            prefixSuffix[i] = j;
        }
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

    // Expected O(n), worst-case O(n*m)
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
            if (tHash == sHash && haystack.substring(i - needle.length(), i).equals(needle)) {
                return i - needle.length();
            }

            tHash -= haystack.charAt(i - needle.length()) * powerS;
            tHash = tHash * BASE + haystack.charAt(i);
        }

        if (tHash == sHash && haystack.substring(haystack.length() - needle.length()).equals(needle)) {
            return haystack.length() - needle.length();
        }

        return -1;
    }
}
