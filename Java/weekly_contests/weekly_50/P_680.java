package weekly_contests.weekly_50;

public class P_680 {

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return isPalindrome(s, start) || isPalindrome(s, end);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int skip) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (start == skip) { start++; }
            if (end == skip) { end--; }
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
