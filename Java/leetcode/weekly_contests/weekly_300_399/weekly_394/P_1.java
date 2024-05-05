package leetcode.weekly_contests.weekly_300_399.weekly_394;

public class P_1 {

    public int numberOfSpecialChars(String word) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            final char l = (char) ('a' + i);
            final char r = (char) ('A' + i);
            if (word.indexOf(l) != -1 && word.indexOf(r) != -1) {
                res++;
            }
        }
        return res;
    }
}
