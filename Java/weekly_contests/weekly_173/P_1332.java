package weekly_contests.weekly_173;

public class P_1332 {

    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        return isPalindrome(s, 0, s.length() - 1) ? 1 : 2;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
