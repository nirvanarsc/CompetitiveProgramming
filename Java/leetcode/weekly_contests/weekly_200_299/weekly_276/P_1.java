package leetcode.weekly_contests.weekly_200_299.weekly_276;

public class P_1 {

    public String[] divideString(String s, int k, char fill) {
        final int n = s.length();
        final int rem = (k - (n % k)) % k;
        final StringBuilder sb = new StringBuilder(s);
        //noinspection StringRepeatCanBeUsed
        for (int i = 0; i < rem; i++) {
            sb.append(fill);
        }
        final String[] res = new String[(n + rem) / k];
        for (int i = 0, j = 0; i < (n + rem) / k; i++) {
            final char[] curr = new char[k];
            for (int l = 0; l < k; l++) {
                curr[l] = sb.charAt(j++);
            }
            res[i] = new String(curr);
        }
        return res;
    }
}
