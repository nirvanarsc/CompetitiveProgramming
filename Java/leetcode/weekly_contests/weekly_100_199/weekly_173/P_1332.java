package leetcode.weekly_contests.weekly_100_199.weekly_173;

public class P_1332 {

    public int removePalindromeSub(String s) {
        return isPalindrome(s) ? 1 : 2;
    }

    private static boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) {
                return false;
            }
        }
        return true;
    }
}
