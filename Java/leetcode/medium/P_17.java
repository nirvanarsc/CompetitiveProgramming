package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_17 {

    static String[] s = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        final List<String> res = new ArrayList<>();
        dfs(digits.toCharArray(), 0, new char[digits.length()], res);
        return res;
    }

    private static void dfs(char[] d, int idx, char[] curr, List<String> res) {
        if (idx == d.length) {
            res.add(new String(curr));
            return;
        }
        for (char c : s[d[idx] - '0'].toCharArray()) {
            curr[idx] = c;
            dfs(d, idx + 1, curr, res);
        }
    }
}
