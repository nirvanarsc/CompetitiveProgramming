package leetcode.weekly_contests.weekly_77;

public class P_806 {

    public int[] numberOfLines(int[] widths, String S) {
        int lines = 1;
        int lastLine = 0;
        for (char c : S.toCharArray()) {
            if (lastLine + widths[c - 'a'] > 100) {
                lastLine = widths[c - 'a'];
                lines++;
            } else {
                lastLine += widths[c - 'a'];
            }
        }
        return new int[] { lines, lastLine };
    }
}
