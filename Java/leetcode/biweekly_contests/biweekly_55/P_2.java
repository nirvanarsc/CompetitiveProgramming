package leetcode.biweekly_contests.biweekly_55;

public class P_2 {

    public String removeOccurrences(String s, String part) {
        while (true) {
            final int idx = s.indexOf(part);
            if (idx == -1) {
                return s;
            }
            s = s.substring(0, idx) + s.substring(idx + part.length());
        }
    }
}
