package leetcode.weekly_contests.weekly_200_299.weekly_291;

public class P_1 {

    public String removeDigit(String number, char digit) {
        int idx = number.lastIndexOf(digit);
        final int n = number.length();
        for (int i = 0; i < n - 1; i++) {
            if (number.charAt(i) == digit && number.charAt(i + 1) > number.charAt(i)) {
                idx = i;
                break;
            }
        }
        return number.substring(0, idx) + number.substring(idx + 1);
    }
}
