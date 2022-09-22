package leetcode.weekly_contests.weekly_0_99.weekly_27;

public class P_557 {

    public String reverseWords(String s) {
        final int n = s.length();
        final char[] res = new char[n];
        final char[] w = s.toCharArray();
        for (int i = 0, k = 0; i <= n; i++) {
            if (i == n || w[i] == ' ') {
                int j = i - 1;
                while (j >= 0 && w[j] != ' ') {
                    res[k++] = w[j--];
                }
                if (k < n) {
                    res[k++] = ' ';
                }
            }
        }
        return new String(res);
    }
}
