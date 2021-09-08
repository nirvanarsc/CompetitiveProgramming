package leetcode.weekly_contests.weekly_88;

public class P_848 {

    public String shiftingLetters(String s, int[] shifts) {
        final char[] chars = s.toCharArray();
        final int n = s.length();
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum = (sum + shifts[i]) % 26;
            chars[i] = (char) ((chars[i] - 'a' + sum) % 26 + 'a');
        }
        return new String(chars);
    }
}
