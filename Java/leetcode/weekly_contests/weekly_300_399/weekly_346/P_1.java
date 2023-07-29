package leetcode.weekly_contests.weekly_300_399.weekly_346;

public class P_1 {

    public int minLength(String s) {
        int idx = s.indexOf("AB");
        if (idx != -1) {
            return minLength(s.substring(0, idx) + s.substring(idx + 2));
        }
        idx = s.indexOf("CD");
        if (idx != -1) {
            return minLength(s.substring(0, idx) + s.substring(idx + 2));
        }
        return s.length();
    }
}
