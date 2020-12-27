package leetcode.weekly_contests.weekly_221;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_1704 {

    public boolean halvesAreAlike(String s) {
        final Set<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        final int n = s.length();
        int a = 0;
        int b = 0;
        for (int i = 0; i < n / 2; i++) {
            if (vowels.contains(s.charAt(i))) {
                a++;
            }
        }
        for (int i = n / 2; i < n; i++) {
            if (vowels.contains(s.charAt(i))) {
                b++;
            }
        }
        return a == b;
    }
}
