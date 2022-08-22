package leetcode.biweekly_contests.biweekly_85;

public class P_3 {

    public String shiftingLetters(String s, int[][] shifts) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        final int[] d = new int[n + 1];
        for (int[] c : shifts) {
            if (c[2] == 1) {
                d[c[0]]++;
                d[c[1] + 1]--;
            } else {
                d[c[0]]--;
                d[c[1] + 1]++;
            }
        }
        int u = 0;
        for (int i = 0; i < n; i++) {
            u = (u + d[i] % 26) % 26;
            int v = w[i] - 'a';
            v = (v + u + 26) % 26;
            w[i] = (char) (v + 'a');
        }
        return new String(w);
    }
}
