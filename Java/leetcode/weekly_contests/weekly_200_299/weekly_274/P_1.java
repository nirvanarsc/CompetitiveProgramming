package leetcode.weekly_contests.weekly_200_299.weekly_274;

public class P_1 {

    public boolean checkString(String s) {
        final int a = s.lastIndexOf('a');
        final int b = s.indexOf('b');
        return b == -1 ? true : a < b;
    }
}
