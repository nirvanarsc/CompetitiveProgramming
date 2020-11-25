package binarysearch.hard;

public class P_11 {

    public int solve(int k, String s) {
        final int[] map = new int[128];
        int j = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]++ == 0) {
                k--;
            }
            while (k < 0) {
                if (--map[s.charAt(j++)] == 0) {
                    k++;
                }
            }
            if (k == 0) {
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}
