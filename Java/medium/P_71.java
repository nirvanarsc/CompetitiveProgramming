package medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class P_71 {

    public static String simplifyPath(String path) {
        final Deque<String> normalizedPath = new LinkedList<>();
        final Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if ("..".equals(dir) && !normalizedPath.isEmpty()) {
                normalizedPath.removeLast();
            } else if (!skip.contains(dir)) {
                normalizedPath.addLast(dir);
            }
        }

        final StringBuilder res = new StringBuilder();
        for (String dir : normalizedPath) {
            res.append('/' + dir);
        }
        return (res.length() == 0) ? "/" : res.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }

    private P_71() {}
}
