package weekly_contests.weekly_131;

import java.util.ArrayList;
import java.util.List;

public class P_1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        final List<Boolean> res = new ArrayList<>();
        final char[] patternArr = pattern.toCharArray();
        for (String query : queries) {
            res.add(match(query.toCharArray(), patternArr));
        }
        return res;
    }

    private static boolean match(char[] queryArr, char[] patternArr) {
        int j = 0;
        for (char c : queryArr) {
            if (j < patternArr.length && c == patternArr[j]) {
                j++;
            } else if (c >= 'A' && c <= 'Z') {
                return false;
            }
        }
        return j == patternArr.length;
    }
}
