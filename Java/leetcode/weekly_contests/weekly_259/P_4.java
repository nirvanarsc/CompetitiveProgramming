package leetcode.weekly_contests.weekly_259;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_4 {

    public String longestSubsequenceRepeatedK(String s, int k) {
        final Deque<String> dq = new ArrayDeque<>();
        dq.offerLast("");
        String res = "";
        while (!dq.isEmpty()) {
            final String curr = dq.removeFirst();
            for (char c = 'a'; c <= 'z'; c++) {
                final String next = curr + c;
                if (isSubsequence(s, next, k)) {
                    dq.offerLast(next);
                    res = next;
                }
            }
        }
        return res;
    }

    private static boolean isSubsequence(String a, String b, int k) {
        final int n = a.length();
        final int m = b.length();
        int j = 0;
        for (int i = 0; i < n && j < k * m; i++) {
            if (a.charAt(i) == b.charAt(j % m)) {
                j++;
            }
        }
        return j == k * m;
    }
}
