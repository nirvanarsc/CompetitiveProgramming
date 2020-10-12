package leetcode.weekly_contests.weekly_88;

public class P_848 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public String shiftingLetters(String S, int[] shifts) {
        final char[] chars = S.toCharArray();
        int sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum += shifts[i] % 26;
            chars[i] = (char) ((chars[i] - 'a' + sum) % 26 + 'a');
        }
        return new String(chars);
    }
}
