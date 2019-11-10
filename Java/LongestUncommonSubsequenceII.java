import java.util.Arrays;

public final class LongestUncommonSubsequenceII {

    public static int findLUSlength(String[] strs) {
        final int len = strs.length;
        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());

        for (int i = 0; i < len; i++) {
            int missMatchCount = strs.length - 1;
            for (int j = 0; j < len; j++) {
                if (i != j && !isSubSequence(strs[i], strs[j])) {
                    missMatchCount--;
                }
            }

            if (missMatchCount == 0) {
                return strs[i].length();
            }
        }

        return -1;
    }

    private static boolean isSubSequence(String s1, String s2) {
        int idx = 0;
        for (char ch : s2.toCharArray()) {
            if (idx < s1.length() && ch == s1.charAt(idx)) {
                idx++;
            }
        }

        return idx == s1.length();
    }

    public static void main(String[] args) {
        System.out.println(findLUSlength(new String[] { "aaa", "aaa", "ab" }));
    }

    private LongestUncommonSubsequenceII() {}
}
