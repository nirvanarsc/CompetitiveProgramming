package leetcode.weekly_contests.weekly_266;

public class P_2 {

    public long countVowels(String word) {
        long res = 0;
        final int n = word.length();
        for (int i = 0; i < n; i++) {
            if ("aeiou".indexOf(word.charAt(i)) != -1) {
                res += (long) (i + 1) * (n - i);
            }
        }
        return res;
    }
}
