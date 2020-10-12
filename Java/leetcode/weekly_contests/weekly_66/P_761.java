package leetcode.weekly_contests.weekly_66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_761 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public String makeLargestSpecial(String S) {
        int count = 0, i = 0;
        final List<String> res = new ArrayList<>();
        for (int j = 0; j < S.length(); ++j) {
            count += S.charAt(j) == '1' ? 1 : -1;
            if (count == 0) {
                res.add('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0');
                i = j + 1;
            }
        }
        res.sort(Collections.reverseOrder());
        return String.join("", res);
    }
}
