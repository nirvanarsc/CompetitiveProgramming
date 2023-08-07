package leetcode.weekly_contests.weekly_300_399.weekly_357;

public class P_1 {

    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                sb = sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
