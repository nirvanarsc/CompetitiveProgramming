package leetcode.weekly_contests.weekly_100_199.weekly_140;

public class P_1081 {

    public String smallestSubsequence(String text) {
        final int[] stack = new int[26];
        final int[] last = new int[26];
        final char[] chars = text.toCharArray();
        int mask = 0;
        for (int i = 0; i < text.length(); i++) {
            last[text.charAt(i) - 'a'] = i;
        }
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((mask & (1 << (chars[i] - 'a'))) == 0) {
                mask |= 1 << (chars[i] - 'a');
                while (j > 0 && stack[j - 1] > chars[i] && i < last[stack[j - 1] - 'a']) {
                    mask ^= 1 << (stack[--j] - 'a');
                }
                stack[j++] = chars[i];
            }
        }
        return new String(stack, 0, j);
    }
}
