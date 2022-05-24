package leetcode.weekly_contests.weekly_0_99.weekly_96;

public class P_880 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public String decodeAtIndex(String S, int K) {
        long curLength = 0;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                curLength *= S.charAt(i) - '0';
            } else {
                curLength++;
            }
        }
        for (int i = S.length() - 1; i >= 0; i--) {
            if (Character.isDigit(S.charAt(i))) {
                curLength /= S.charAt(i) - '0';
                K %= curLength;
            } else {
                if (K == 0 || K == curLength) {
                    return String.valueOf(S.charAt(i));
                }
                curLength--;
            }
        }
        return "";
    }
}
