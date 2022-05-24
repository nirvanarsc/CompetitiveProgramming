package leetcode.weekly_contests.weekly_200_299.weekly_289;

public class P_1 {

    public String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            sb.append(f(s.substring(i, Math.min(s.length(), i + k))));
        }
        //noinspection TailRecursion
        return digitSum(sb.toString(), k);
    }

    private static String f(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res += c - '0';
        }
        return String.valueOf(res);
    }
}
