package leetcode.weekly_contests.weekly_0_99.weekly_35;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P_609 {

    public List<List<String>> findDuplicate(String[] paths) {
        final Map<String, List<String>> f = new HashMap<>();
        for (String p : paths) {
            final String[] split = p.split(" ");
            final String pre = split[0];
            for (int i = 1; i < split.length; i++) {
                final String curr = split[i];
                final int l = curr.indexOf('(');
                final int r = curr.indexOf(')');
                final String content = curr.substring(l + 1, r);
                final String fileName = curr.substring(0, l);
                f.computeIfAbsent(content, val -> new ArrayList<>()).add(pre + '/' + fileName);
            }
        }
        return f.values()
                .stream()
                .filter(list -> list.size() > 1)
                .collect(Collectors.toUnmodifiableList());
    }
}
