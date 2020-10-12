package leetcode.weekly_contests.weekly_57;

import java.util.ArrayList;
import java.util.List;

public class P_722 {

    public List<String> removeComments(String[] source) {
        final StringBuilder curr = new StringBuilder();
        final List<String> res = new ArrayList<>();
        boolean inComment = false;
        for (String src : source) {
            for (int i = 0; i < src.length(); i++) {
                if (inComment) {
                    if (i + 1 < src.length() && src.charAt(i) == '*' && src.charAt(i + 1) == '/') {
                        inComment = false;
                        i++;
                    }
                } else {
                    if (i + 1 < src.length() && src.charAt(i) == '/' && src.charAt(i + 1) == '/') {
                        break;
                    } else if (i + 1 < src.length() && src.charAt(i) == '/' && src.charAt(i + 1) == '*') {
                        inComment = true;
                        i++;
                    } else {
                        curr.append(src.charAt(i));
                    }
                }
            }
            if (!inComment && curr.length() > 0) {
                res.add(curr.toString());
                curr.setLength(0);
            }
        }
        return res;
    }
}
