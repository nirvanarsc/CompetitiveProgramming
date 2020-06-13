package hard;

public class P_316 {

    public String removeDuplicateLetters(String s) {
        final int[] stack = new int[26];
        final int[] last = new int[26];
        final boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int j = -1;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            final int idx = s.charAt(i) - 'a';
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
