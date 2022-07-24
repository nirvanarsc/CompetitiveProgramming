package leetcode.weekly_contests.weekly_300_399.weekly_303;

public class P_1 {

    public char repeatedCharacter(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            if ((mask & (1 << (c - 'a'))) != 0) {
                return c;
            }
            mask |= 1 << (c - 'a');
        }
        return '#';
    }
}
