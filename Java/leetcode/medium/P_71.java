package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_71 {

    public String simplifyPath(String path) {
        final Deque<String> dq = new ArrayDeque<>();
        final Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if ("..".equals(dir) && !dq.isEmpty()) {
                dq.removeLast();
            } else if (!skip.contains(dir)) {
                dq.addLast(dir);
            }
        }
        final StringBuilder res = new StringBuilder();
        for (String dir : dq) {
            res.append('/');
            res.append(dir);
        }
        return (res.length() == 0) ? "/" : res.toString();
    }
}
