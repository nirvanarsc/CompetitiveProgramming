package leetcode.weekly_contests.weekly_3;

public class P_392 {

    public boolean isSubsequence(String s, String t) {
        final int n = s.length();
        final int m = t.length();
        int i = 0;
        for (int j = 0; j < m; j++) {
            if (i < n && t.charAt(j) == s.charAt(i)) {
                i++;
            }
        }
        return i == n;
    }

    public boolean isSubsequenceIndexOf(String s, String t) {
        int stay = 0, move = 0;
        while (stay < s.length()) {
            final int index = t.indexOf(s.charAt(stay), move);
            if (index == -1) {
                return false;
            }
            stay++;
            move = index + 1;
        }

        return true;
    }
}
