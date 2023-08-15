package leetcode.weekly_contests.weekly_300_399.weekly_339;

public class P_1 {

    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        //noinspection NonConstantStringShouldBeStringBuffer
        String find = "";
        while (s.contains(find)) {
            find = '0' + find + '1';
            res = find.length();
        }
        return res - 2;
    }
}
