package leetcode.weekly_contests.weekly_26;

public class P_522 {

    public int findLUSlength(String[] strs) {
        final int n = strs.length;
        int res = -1;
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (isSubsequence(strs[i], strs[j])) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i < s.length() && t.charAt(j) == s.charAt(i)) {
                i++;
            }
        }
        return i == s.length();
    }
}
