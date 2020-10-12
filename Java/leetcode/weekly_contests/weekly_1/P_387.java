package leetcode.weekly_contests.weekly_1;

public class P_387 {

    public int firstUniqChar(String s) {
        int mask1 = 0, mask2 = 0;
        final char[] chars = s.toCharArray();
        for (char c : chars) {
            final int pos = c - 'a';
            if (!getBit(mask1, pos)) {
                mask1 |= 1 << pos;
            } else if (!getBit(mask2, pos)) {
                mask2 |= 1 << pos;
            }
        }

        for (int i = 0; i < chars.length; i++) {
            final int pos = chars[i] - 'a';
            if (getBit(mask1, pos) ^ getBit(mask2, pos)) {
                return i;
            }
        }

        return -1;
    }

    private static boolean getBit(int n, int i) {
        return (n & 1 << i) != 0;
    }

    public int firstUniqCharMap(String s) {
        final int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
