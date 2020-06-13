package weekly_contests.weekly_140;

public class P_1081 {

    public String smallestSubsequence(String text) {
        final int[] stack = new int[26];
        final int[] last = new int[26];
        final boolean[] seen = new boolean[26];
        for (int i = 0; i < text.length(); i++) {
            last[text.charAt(i) - 'a'] = i;
        }
        int j = -1;
        for (int i = 0; i < text.length(); i++) {
            final char c = text.charAt(i);
            final int idx = text.charAt(i) - 'a';
            if (!seen[idx]) {
                seen[idx] = true;
                while (j > -1 && stack[j] > c && i < last[stack[j] - 'a']) {
                    seen[stack[j--] - 'a'] = false;
                }
                stack[++j] = c;
            }
        }
        return new String(stack, 0, j + 1);
    }
}
