package leetcode.weekly_contests.weekly_142;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class P_1096 {

    public List<String> braceExpansionII(String expression) {
        final Deque<String> queue = new ArrayDeque<>(Collections.singletonList(expression));
        final Set<String> set = new TreeSet<>();

        while (!queue.isEmpty()) {
            final String str = queue.removeFirst();

            if (str.indexOf('{') == -1) {
                set.add(str);
                continue;
            }

            int l = 0, r = 0;
            while (str.charAt(r) != '}') {
                if (str.charAt(r) == '{') {
                    l = r;
                }
                r++;
            }

            final String before = str.substring(0, l);
            final String after = str.substring(r + 1);
            final String[] middle = str.substring(l + 1, r).split(",");

            for (String mid : middle) {
                queue.offerLast(new StringBuilder().append(before).append(mid).append(after).toString());
            }
        }

        return new ArrayList<>(set);
    }
}
