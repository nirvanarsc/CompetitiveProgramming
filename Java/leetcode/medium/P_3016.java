package leetcode.medium;

import java.util.Arrays;

public class P_3016 {

    public int minimumPushes(String word) {
        final int[] f = new int[26];
        for (char c : word.toCharArray()) {
            f[c - 'a']++;
        }
        Arrays.sort(f);
        int res = 0;
        for (int i = 25, j = 0; i >= 0; i--, j++) {
            res += f[i] * (1 + (j / 8));
        }
        return res;
    }
}
