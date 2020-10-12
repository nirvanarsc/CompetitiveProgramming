package leetcode.weekly_contests.weekly_11;

@SuppressWarnings("DynamicRegexReplaceableByCompiledPattern")
public class P_434 {

    public int countSegments(String s) {
        int res = 0;
        for (String w : s.split("\\s+")) {
            res += w.isEmpty() ? 0 : 1;
        }
        return res;
    }
}
