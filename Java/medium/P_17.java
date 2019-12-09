package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class P_17 {

    private static final String[] NUMBERS =
            { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return Collections.emptyList();
        }
        final List<String> res = new ArrayList<>();
        dfs("", 0, digits, res);
        return res;
    }

    private static void dfs(String curr, int idx, String digits, List<String> list) {
        if (idx == digits.length()) {
            list.add(curr);
            return;
        }

        for (int i = 0; i < NUMBERS[digits.charAt(idx) - '0'].length(); i++) {
            dfs(curr + NUMBERS[digits.charAt(idx) - '0'].charAt(i), idx + 1, digits, list);
        }
    }

    private P_17() {}
}
