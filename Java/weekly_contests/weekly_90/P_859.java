package weekly_contests.weekly_90;

import java.util.ArrayList;
import java.util.List;

public class P_859 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            final int[] map = new int[26];
            for (char c : A.toCharArray()) {
                if (map[c - 'a']++ > 0) {
                    return true;
                }
            }
            return false;
        }
        final List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                diff.add(i);
            }
        }
        return diff.size() == 2 &&
               A.charAt(diff.get(0)) == B.charAt(diff.get(1)) &&
               A.charAt(diff.get(1)) == B.charAt(diff.get(0));
    }
}
