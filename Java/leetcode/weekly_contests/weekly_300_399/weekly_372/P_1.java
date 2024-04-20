package leetcode.weekly_contests.weekly_300_399.weekly_372;

public class P_1 {

    public int findMinimumOperations(String s1, String s2, String s3) {
        int maxPrefix = -1;
        for (int i = 0; i < Math.min(s1.length(), Math.min(s2.length(), s3.length())); i++) {
            if (s1.charAt(i) != s2.charAt(i) || s1.charAt(i) != s3.charAt(i)) {
                break;
            }
            maxPrefix++;
        }
        return maxPrefix == -1 ? maxPrefix : (s1.length() + s2.length() + s3.length()) - 3 * (maxPrefix + 1);
    }
}
