package weekly_contests.weekly_198;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_1520 {

    public List<String> maxNumOfSubstrings(String str) {
        final Set<Character> chars = new HashSet<>();
        final List<int[]> ranges = new ArrayList<>();
        final int[] start = new int[26];
        final int[] end = new int[26];
        Arrays.fill(start, Integer.MAX_VALUE);
        Arrays.fill(end, Integer.MIN_VALUE);
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            chars.add(c);
            start[c - 'a'] = Math.min(start[c - 'a'], i);
            end[c - 'a'] = Math.max(end[c - 'a'], i);
        }
        for (char c : chars) {
            boolean valid = true;
            for (int i = start[c - 'a']; i < end[c - 'a']; ++i) {
                if (start[str.charAt(i) - 'a'] < start[c - 'a']) {
                    valid = false;
                    break;
                }
                end[c - 'a'] = Math.max(end[c - 'a'], end[str.charAt(i) - 'a']);
            }
            if (valid) {
                ranges.add(new int[] { start[c - 'a'], end[c - 'a'] });
            }
        }
        ranges.sort(Comparator.comparingInt(s -> s[1]));
        return getRes(str, ranges);
    }

    private static List<String> getRes(String str, List<int[]> ranges) {
        final List<String> res = new ArrayList<>();
        res.add(str.substring(ranges.get(0)[0], ranges.get(0)[1] + 1));
        int prevEnd = ranges.get(0)[1];
        for (int i = 1; i < ranges.size(); i++) {
            final int[] curr = ranges.get(i);
            if (curr[0] < prevEnd) {
                continue;
            }
            res.add(str.substring(curr[0], curr[1] + 1));
            prevEnd = curr[1];
        }
        return res;
    }
}
