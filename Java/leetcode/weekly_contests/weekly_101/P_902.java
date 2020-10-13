package leetcode.weekly_contests.weekly_101;

public class P_902 {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        final String str = String.valueOf(n);
        final int[] pow = new int[10];
        pow[0] = 1;
        for (int i = 1; i < 10; i++) {
            pow[i] = pow[i - 1] * digits.length;
        }
        int res = 0;
        for (int i = 1; i < str.length(); i++) {
            res += pow[i];
        }
        for (int i = 0; i < str.length(); i++) {
            boolean hasSameNum = false;
            for (String d : digits) {
                if (d.charAt(0) < str.charAt(i)) {
                    res += pow[str.length() - i - 1];
                } else if (d.charAt(0) == str.charAt(i)) {
                    hasSameNum = true;
                }
            }
            if (!hasSameNum) {
                return res;
            }
        }
        return res + 1;
    }
}
