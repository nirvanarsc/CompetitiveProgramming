package leetcode.weekly_contests.weekly_0_99.weekly_8;

public class P_415 {

    public String addStrings(String num1, String num2) {
        final StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            final int next = (i >= 0 ? num1.charAt(i) - '0' : 0) + (j >= 0 ? num2.charAt(j) - '0' : 0) + carry;
            sb.append(next % 10);
            carry = next / 10;
            i--;
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
