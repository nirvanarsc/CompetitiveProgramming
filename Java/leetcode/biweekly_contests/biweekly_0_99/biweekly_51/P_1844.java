package leetcode.biweekly_contests.biweekly_0_99.biweekly_51;

public class P_1844 {

    public String replaceDigits(String s) {
        final char[] w = s.toCharArray();
        for (int i = 1; i < w.length; i += 2) {
            w[i] = (char) (w[i] + w[i - 1] - '0');
        }
        return new String(w);
    }
}
