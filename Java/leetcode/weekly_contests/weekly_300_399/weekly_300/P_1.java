package leetcode.weekly_contests.weekly_300_399.weekly_300;

public class P_1 {

    public String decodeMessage(String key, String message) {
        final int[] map = new int[26];
        int mask = 0;
        int curr = 0;
        for (char c : key.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if ((mask & (1 << (c - 'a'))) == 0) {
                map[c - 'a'] = curr++;
                mask |= 1 << (c - 'a');
            }
        }
        final int n = message.length();
        final char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            final char c = message.charAt(i);
            if (c == ' ') {
                res[i] = ' ';
            } else {
                res[i] = (char) ('a' + map[c - 'a']);
            }
        }
        return new String(res);
    }
}
