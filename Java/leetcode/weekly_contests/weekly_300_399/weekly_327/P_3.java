package leetcode.weekly_contests.weekly_300_399.weekly_327;

public class P_3 {

    public boolean isItPossible(String word1, String word2) {
        final int[] l = new int[26];
        final int[] r = new int[26];
        int ll = 0;
        int rr = 0;
        for (char c : word1.toCharArray()) {
            ll |= 1 << (c - 'a');
            l[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            rr |= 1 << (c - 'a');
            r[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (l[i] == 0 || r[j] == 0) {
                    continue;
                }
                int m1 = ll;
                int m2 = rr;
                if (l[i] == 1) {
                    m1 ^= 1 << i;
                }
                if (r[j] == 1) {
                    m2 ^= 1 << j;
                }
                m1 |= 1 << j;
                m2 |= 1 << i;
                if (Integer.bitCount(m1) == Integer.bitCount(m2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
