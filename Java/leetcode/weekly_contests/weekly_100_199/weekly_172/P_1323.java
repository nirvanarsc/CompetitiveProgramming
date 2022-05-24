package leetcode.weekly_contests.weekly_100_199.weekly_172;

public class P_1323 {

    public int maximum69Number(int num) {
        final String asString = String.valueOf(num);
        final int i = asString.indexOf('6');
        if (i >= 0) {
            final char[] chars = asString.toCharArray();
            chars[i] = '9';
            return Integer.parseInt(new String(chars));
        }
        return num;
    }
}
