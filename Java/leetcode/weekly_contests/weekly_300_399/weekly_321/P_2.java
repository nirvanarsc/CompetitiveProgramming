package leetcode.weekly_contests.weekly_300_399.weekly_321;

public class P_2 {

    public int appendCharacters(String s, String t) {
        final char[] l = s.toCharArray();
        final char[] r = t.toCharArray();
        int idx = 0;
        for (char c : l) {
            if (idx < r.length && c == r[idx]) {
                idx++;
            }
        }
        return r.length - idx;
    }
}
