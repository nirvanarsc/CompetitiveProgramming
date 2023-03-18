package leetcode.biweekly_contests.biweekly_0_99.biweekly_58;

public class P_1 {

    public String makeFancyString(String s) {
        final StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 1 && sb.charAt(sb.length() - 2) == c && sb.charAt(sb.length() - 1) == c) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
