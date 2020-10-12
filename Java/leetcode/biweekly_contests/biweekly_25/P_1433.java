package leetcode.biweekly_contests.biweekly_25;

import java.util.Arrays;

public class P_1433 {

    public boolean checkIfCanBreak(String s1, String s2) {
        final char[] chars1 = s1.toCharArray();
        final char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return canBreak(chars1, chars2) || canBreak(chars2, chars1);
    }

    private static boolean canBreak(char[] left, char[] right) {
        for (int i = 0; i < left.length; i++) {
            if (left[i] < right[i]) {
                return false;
            }
        }
        return true;
    }
}
