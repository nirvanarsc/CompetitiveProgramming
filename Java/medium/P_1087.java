package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_1087 {

    public static final String[] EMPTY = new String[0];

    public String[] expand(String string) {
        final List<List<Character>> list = new ArrayList<>();
        final List<Character> curr = new ArrayList<>();
        boolean open = false;
        for (char c : string.toCharArray()) {
            if (c == ',') { continue; }
            if (!open && c != '{') {
                list.add(Collections.singletonList(c));
            } else if (c == '{') {
                open = true;
            } else if (c != '}') { curr.add(c); } else {
                list.add(new ArrayList<>(curr));
                curr.clear();
                open = false;
            }
        }
        list.forEach(Collections::sort);
        final List<String> res = new ArrayList<>();
        recurse(res, 0, list, new StringBuilder());
        return res.toArray(EMPTY);
    }

    private static void recurse(List<String> res, int start, List<List<Character>> chars, StringBuilder sb) {
        if (start == chars.size()) {
            res.add(sb.toString());
            return;
        }
        for (Character c : chars.get(start)) {
            sb.append(c);
            recurse(res, start + 1, chars, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
