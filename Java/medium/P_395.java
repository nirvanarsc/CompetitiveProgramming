package medium;

public class P_395 {

    public int longestSubstring(String s, int k) {
        if (k == 1) {
            return s.length();
        }

        final int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        char bad = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                bad = (char) (i + 'a');
                break;
            }
        }
        if (bad == 0) {
            return s.length();
        }
        int res = 0;
        for (String sub : s.split(String.valueOf(bad))) {
            res = Math.max(res, longestSubstring(sub, k));
        }
        return res;
    }
}
