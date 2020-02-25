package biweekly_contests.biweekly_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_1087 {

    public static final String[] STRINGS = new String[0];

    public String[] expand(String s) {
        final List<List<String>> chars = new ArrayList<>();
        final List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                final int endIndex = s.indexOf('}', i);
                chars.add(Arrays.asList(s.substring(i + 1, endIndex).split(",")));
                i = endIndex;
            } else {
                chars.add(Collections.singletonList(s.substring(i, i + 1)));
            }
        }
        for (List<String> t : chars) {
            Collections.sort(t);
        }
        recurse(chars, 0, new StringBuilder(), res);
        return res.toArray(STRINGS);
    }

    private static void recurse(List<List<String>> s, int i, StringBuilder sb, List<String> res) {
        if (i == s.size()) {
            res.add(sb.toString());
            return;
        }

        for (String t : s.get(i)) {
            sb.append(t);
            recurse(s, i + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
