package leetcode.weekly_contests.weekly_0_99.weekly_19;

public class P_504 {

    public String convertToBase7(int num) {
        if (num == 0) { return "0"; }
        final StringBuilder sb = new StringBuilder();
        final boolean negative = num < 0;
        num = Math.abs(num);
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (negative) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }

    public String convertToBase7Library(int num) {
        return Integer.toString(num, 7);
    }
}
