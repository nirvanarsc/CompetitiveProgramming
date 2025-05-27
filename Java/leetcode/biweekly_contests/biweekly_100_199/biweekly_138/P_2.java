package leetcode.biweekly_contests.biweekly_100_199.biweekly_138;

public class P_2 {

    public String stringHash(String s, int k) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        final char[] res = new char[n / k];
        int curr = 0;
        for (int i = 0, j = 0; i < n; i++) {
            curr += w[i] - 'a';
            curr %= 26;
            if ((i + 1) == (j + 1) * k) {
                res[j++] = (char) (curr + 'a');
                curr = 0;
            }
        }
        return new String(res);
    }
}
