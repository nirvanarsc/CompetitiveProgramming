package leetcode.medium;

public class P_318 {

    public int maxProduct(String[] words) {
        final int n = words.length;
        final int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = 0;
            final char[] w = words[i].toCharArray();
            for (char c : w) {
                curr |= 1 << (c - 'a');
            }
            masks[i] = curr;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
