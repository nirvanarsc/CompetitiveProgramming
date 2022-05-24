package leetcode.weekly_contests.weekly_200_299.weekly_246;

public class P_1 {

    public String largestOddNumber(String num) {
        final int n = num.length();
        for (int i = n; i >= 1; i--) {
            if ((num.charAt(i - 1) - '0') % 2 != 0) {
                return num.substring(0, i);
            }
        }
        return "";
    }
}
