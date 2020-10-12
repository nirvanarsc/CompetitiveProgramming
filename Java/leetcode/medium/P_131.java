package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public final class P_131 {

    public static List<List<String>> partition(String s) {
        final List<List<String>> res = new ArrayList<>();
        recurse(0, s, res, new ArrayList<>());
        return res;
    }

    private static void recurse(int start, String s, List<List<String>> res, List<String> curr) {
        if (start == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (isPalindrome(s, start, i - 1)) {
                curr.add(s.substring(start, i));
                recurse(i, s, res, curr);
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

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    private P_131() {}
}
