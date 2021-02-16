package leetcode.weekly_contests.weekly_72;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_784 {

    public List<String> letterCasePermutationDFS(String S) {
        final List<String> res = new ArrayList<>();
        dfs(S.toCharArray(), 0, res);
        return res;
    }

    private static void dfs(char[] chars, int idx, List<String> res) {
        if (idx == chars.length) {
            res.add(new String(chars));
            return;
        }
        if (Character.isLetter(chars[idx])) {
            chars[idx] = Character.toLowerCase(chars[idx]);
            dfs(chars, idx + 1, res);
            chars[idx] = Character.toUpperCase(chars[idx]);
        }
        dfs(chars, idx + 1, res);
    }

    public List<String> letterCasePermutationBFS(String S) {
        final Deque<String> q = new ArrayDeque<>(Collections.singletonList(S));
        for (int i = 0; i < S.length(); i++) {
            final char c = S.charAt(i);
            if (Character.isLetter(c)) {
                for (int size = q.size(); size > 0; size--) {
                    final String curr = q.removeFirst();
                    q.offerLast(curr.substring(0, i) + Character.toLowerCase(c) + curr.substring(i + 1));
                    q.offerLast(curr.substring(0, i) + Character.toUpperCase(c) + curr.substring(i + 1));
                }
            }
        }
        return new ArrayList<>(q);
    }

    public List<String> letterCasePermutation(String S) {
        int n = 0;
        final char[] s = S.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (!isDigit(s[i])) {
                if ('A' <= s[i] && s[i] <= 'Z') {
                    s[i] ^= 32;
                }
                n++;
            }
        }
        final List<String> res = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            int maskIdx = 0;
            final char[] curr = s.clone();
            for (int i = 0; i < curr.length; i++) {
                if (!isDigit(curr[i])) {
                    if ((mask & (1 << maskIdx)) != 0) {
                        curr[i] ^= 32;
                    }
                    maskIdx++;
                }
            }
            res.add(new String(curr));
        }
        return res;
    }

    private static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }
}
