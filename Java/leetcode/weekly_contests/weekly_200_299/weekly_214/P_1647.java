package leetcode.weekly_contests.weekly_200_299.weekly_214;

import java.util.Arrays;

public class P_1647 {

    public int minDeletions(String s) {
        final int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        final boolean[] seen = new boolean[freq[25] + 1];
        int res = 0;
        for (int i = 0; i < 26; i++) {
            final int f = freq[i];
            if (f == 0) {
                continue;
            }
            if (!seen[f]) {
                seen[f] = true;
            } else {
                int val = f - 1;
                while (val > 0 && seen[val]) {
                    val--;
                }
                if (val == 0) {
                    res += f;
                } else {
                    res += f - val;
                    seen[val] = true;
                }
            }
        }
        return res;
    }
}
