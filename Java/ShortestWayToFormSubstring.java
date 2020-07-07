public final class ShortestWayToFormSubstring {

    public static void main(String[] args) {
        System.out.println(shortestWayToFormSubstring("abcd", "dbcfda"));
        System.out.println(shortestWayToFormSubstring("abc", "abdabb"));
        System.out.println(shortestWayToFormSubstring("abcd", "fabcda"));
        System.out.println(shortestWayToFormSubstring("zaza", "baz"));
        System.out.println();
        System.out.println(shortestWayToFormSuffix("zaza", "baz")); // -1
        System.out.println(shortestWayToFormSuffix("zazaz", "baz")); // 3
        System.out.println(shortestWayToFormSuffix("vvav", "vav")); // 2
        System.out.println(shortestWayToFormSuffix("abcabdabcabc", "abdabcabc")); // 2
        System.out.println(shortestWayToFormSuffix("vavavvav", "vavav")); // 2
        System.out.println(shortestWayToFormSuffix("abcabcabcabcabc", "abcabc")); // 3
        System.out.println(shortestWayToFormSuffix("cdcdcdcd", "dcd")); // 4
        System.out.println(shortestWayToFormSuffix("cbaaa", "dcbaa")); // 2
        System.out.println(shortestWayToFormSuffix("aaaaaaaaa", "aa")); // 5
        System.out.println(shortestWayToFormSuffix("baabaaba", "baaba")); // 2
        System.out.println(shortestWayToFormSuffix("aacaabaabaacaabaab", "aacaab")); // 4
        System.out.println(shortestWayToFormSuffix("acadacacacadacac ", "adacac")); // 4
    }

    // O(T*(T+S))
    // https://leetcode.com/discuss/interview-question/365191/Google-or-Form-String-A-from-suffix-of-String-B
    private static int shortestWayToFormSuffix(String target, String source) {
        String combined = target + '#' + source;
        int res = 0;

        while (combined.length() > source.length() + 1) {
            res++;
            final int[] kmp = kmp(combined);
            if (kmp[1] == 0) {
                return -1;
            }
            combined = combined.substring(kmp[1]);
        }
        return res;
    }

    // O(T*(T+S))
    // https://leetcode.com/discuss/interview-question/217510/google-phone-screen-shortest-way-to-form-string
    // https://leetcode.com/discuss/interview-question/363692/Google-or-Onsite-or-Shortest-Way-to-Form-Substring
    private static int shortestWayToFormSubstring(String target, String source) {
        String combined = target + source;
        int res = 0;
        int[] kmp = kmp(combined);
        if (kmp[0] == target.length()) {
            return 0;
        }
        combined = combined.substring(kmp[1]);
        while (combined.length() > source.length()) {
            res++;
            kmp = kmp(combined);
            if (kmp[0] == 0) {
                return -1;
            }
            combined = combined.substring(kmp[0]);
        }
        return res;
    }

    private static int[] kmp(String s) {
        final int n = s.length();
        final int[] prefixSuffix = new int[n];
        int max = 0;
        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefixSuffix[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            prefixSuffix[i] = j;
            max = Math.max(max, prefixSuffix[i]);
        }
        return new int[] { max, prefixSuffix[s.length() - 1] };
    }

    // TODO O(t + s^2) with prefix // suffix tree
}
