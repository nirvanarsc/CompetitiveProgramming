package leetcode.weekly_contests.weekly_100_199.weekly_158;

public class P_1221 {

    public int balancedStringSplit(String s) {
        int res = 0, r = 0;
        for (char c : s.toCharArray()) {
            r += c == 'R' ? 1 : -1;
            res += r == 0 ? 1 : 0;
        }
        return res;
    }
}
