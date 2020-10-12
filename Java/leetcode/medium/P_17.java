package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_17 {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        final String[] nums = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        final List<String> res = new ArrayList<>();
        dfs(digits, 0, nums, res, new StringBuilder());
        return res;
    }

    private static void dfs(String digits, int i, String[] nums, List<String> res, StringBuilder curr) {
        if (i == digits.length()) {
            res.add(new String(curr));
            return;
        }
        for (char c : nums[digits.charAt(i) - '0'].toCharArray()) {
            curr.append(c);
            dfs(digits, i + 1, nums, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
