package leetcode.weekly_contests.weekly_0_99.weekly_18a;

import java.util.ArrayList;
import java.util.List;

public class P_500 {

    public String[] findWords(String[] words) {
        final String row1 = "qwertyuiop";
        final String row2 = "asdfghjkl";
        final String row3 = "zxcvbnm";
        final List<String> res = new ArrayList<>();
        for (String w : words) {
            if (canWrite(w, row1) || canWrite(w, row2) || canWrite(w, row3)) {
                res.add(w);
            }
        }
        return res.toArray(String[]::new);
    }

    private static boolean canWrite(String w, String row) {
        w = w.toLowerCase();
        boolean canWrite = true;
        for (char c : w.toCharArray()) {
            if (row.indexOf(c) == -1) {
                canWrite = false;
                break;
            }
        }
        return canWrite;
    }
}
