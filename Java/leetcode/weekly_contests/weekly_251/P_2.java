package leetcode.weekly_contests.weekly_251;

public class P_2 {

    public String maximumNumber(String num, int[] change) {
        final int n = num.length();
        final char[] res = num.toCharArray();
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) - '0' < change[num.charAt(i) - '0']) {
                int j = i;
                while (j < n && num.charAt(j) - '0' <= change[num.charAt(j) - '0']) {
                    j++;
                }
                for (int k = i; k < j; k++) {
                    res[k] = (char) (change[num.charAt(k) - '0'] + '0');
                }
                break;
            }
        }
        return new String(res);
    }
}
