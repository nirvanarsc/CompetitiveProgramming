package leetcode.weekly_contests.weekly_200_299.weekly_221;

public class P_1704 {

    public boolean halvesAreAlike(String s) {
        final String vowels = "aeiouAEIOU";
        final int n = s.length();
        final char[] w = s.toCharArray();
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            if (vowels.indexOf(w[i]) >= 0) {
                count++;
            }
            if (vowels.indexOf(w[i + (n / 2)]) >= 0) {
                count--;
            }
        }
        return count == 0;
    }
}
