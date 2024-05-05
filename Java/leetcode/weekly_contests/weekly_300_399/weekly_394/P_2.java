package leetcode.weekly_contests.weekly_300_399.weekly_394;

public class P_2 {

    public int numberOfSpecialChars(String word) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            final char l = (char) ('a' + i);
            final char r = (char) ('A' + i);
            final int u = word.lastIndexOf(l);
            final int v = word.indexOf(r);
            if (u != -1 && v != -1 && u < v) {
                res++;
            }
        }
        return res;
    }
}
