package leetcode.weekly_contests.weekly_0_99.weekly_86;

import java.util.ArrayList;
import java.util.List;

public class P_842 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public List<Integer> splitIntoFibonacci(String S) {
        final List<Integer> res = new ArrayList<>();
        helper(S, res, 0);
        return res;
    }

    public boolean helper(String s, List<Integer> ans, int idx) {
        if (idx == s.length() && ans.size() >= 3) {
            return true;
        }
        for (int i = idx; i < s.length(); i++) {
            if (s.charAt(idx) == '0' && i > idx) {
                return false;
            }
            final long num = Long.parseLong(s.substring(idx, i + 1));
            if (num > Integer.MAX_VALUE) {
                return false;
            }
            final int size = ans.size();
            if (size >= 2 && num > ans.get(size - 1) + ans.get(size - 2)) {
                return false;
            }
            if (size <= 1 || num == ans.get(size - 1) + ans.get(size - 2)) {
                ans.add((int) num);
                if (helper(s, ans, i + 1)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }
}
