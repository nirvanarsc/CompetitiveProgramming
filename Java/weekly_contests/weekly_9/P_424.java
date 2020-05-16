package weekly_contests.weekly_9;

public class P_424 {

    public int characterReplacement(String s, int k) {
        int res = 0;
        final char[] chars = s.toCharArray();
        for (char c = 'A'; c <= 'Z'; c++) {
            res = Math.max(res, findMaxConsecutiveChar(chars, c, k));
        }
        return res;
    }

    public int findMaxConsecutiveChar(char[] chars, char c, int k) {
        int j = 0, res = 0;
        for (int i = 0; i < chars.length; i++) {
            k -= chars[i] == c ? 0 : 1;
            while (k < 0) {
                k += chars[j++] == c ? 0 : 1;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public int characterReplacementSpace(String s, int k) {
        final int len = s.length();
        final int[] count = new int[26];
        int j = 0, maxCount = 0, maxLength = 0;
        for (int i = 0; i < len; i++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(i) - 'A']);
            while (i - j + 1 - maxCount > k) {
                count[s.charAt(j) - 'A']--;
                j++;
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }
}
