package leetcode.weekly_contests.weekly_101;

public class P_902 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int atMostNGivenDigitSet(String[] D, int N) {
        int ans = 0;
        int pow = D.length;
        final String num = String.valueOf(N);

        for (int i = 1; i < num.length(); i++) {
            ans += pow;
            pow *= D.length;
        }

        for (int i = 0; i < num.length(); i++) {
            boolean hasSameNum = false;
            for (String digit : D) {
                if (digit.charAt(0) < num.charAt(i)) {
                    ans += Math.pow(D.length, num.length() - 1 - i);
                } else if (digit.charAt(0) == num.charAt(i)) {
                    hasSameNum = true;
                }
            }
            if (!hasSameNum) {
                return ans;
            }
        }

        return ans + 1;
    }
}
