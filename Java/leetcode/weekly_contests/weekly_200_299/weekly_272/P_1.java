package leetcode.weekly_contests.weekly_200_299.weekly_272;

public class P_1 {

    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (isPalindrome(s.toCharArray())) {
                return s;
            }
        }
        return "";
    }

    private static boolean isPalindrome(char[] w) {
        int l = 0;
        int r = w.length - 1;
        while (l < r) {
            if (w[l++] != w[r--]) {
                return false;
            }
        }
        return true;
    }
}
