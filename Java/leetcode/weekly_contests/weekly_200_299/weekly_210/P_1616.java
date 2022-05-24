package leetcode.weekly_contests.weekly_200_299.weekly_210;

public class P_1616 {

    public boolean checkPalindromeFormation(String a, String b) {
        final char[] aa = a.toCharArray();
        final char[] bb = b.toCharArray();
        return check(bb, aa) || check(aa, bb);
    }

    private static boolean check(char[] a, char[] b) {
        int start = 0, end = a.length - 1;
        while (start < end && a[start] == b[end]) {
            if (a[start++] != b[end--]) {
                break;
            }
        }
        return isPalindrome(a, start, end) || isPalindrome(b, start, end);
    }

    private static boolean isPalindrome(char[] s, int start, int end) {
        while (start < end) {
            if (s[start++] != s[end--]) {
                return false;
            }
        }
        return true;
    }
}
