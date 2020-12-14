package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class P_131 {

    public List<List<String>> partition(String s) {
        final List<List<String>> res = new ArrayList<>();
        dfs(0, s, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(int start, String s, List<String> curr, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (isPalindrome(s, start, i - 1)) {
                curr.add(s.substring(start, i));
                dfs(i, s, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
