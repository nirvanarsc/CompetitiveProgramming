package leetcode.weekly_contests.weekly_300_399.weekly_347;

public class P_1 {

    public String removeTrailingZeros(String num) {
        return num.replace('0', ' ').stripTrailing().replace(' ', '0');
    }
}
