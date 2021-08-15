package leetcode.hard;

public final class P_76 {

    public String minWindow(String s, String t) {
        final int[] map = new int[256];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int k = t.length();
        final char[] w = s.toCharArray();
        int j = 0;
        int minL = (int) 1e9;
        int minS = -1;
        for (int i = 0; i < w.length; i++) {
            if (map[w[i]]-- > 0) {
                k--;
            }
            while (k == 0) {
                final int currL = i - j + 1;
                if (currL < minL) {
                    minL = currL;
                    minS = j;
                }
                if (++map[w[j++]] > 0) {
                    k++;
                }
            }
        }
        return minL == (int) 1e9 ? "" : s.substring(minS, minS + minL);
    }
}
