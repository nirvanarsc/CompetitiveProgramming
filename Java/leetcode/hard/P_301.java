package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class P_301 {

    int min = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        final List<String> res = new ArrayList<>();
        dfs(s, new StringBuilder(), 0, 0, 0, 0, res);
        return new ArrayList<>(res);
    }

    private void dfs(String s, StringBuilder sb, int open, int close, int delete, int idx, List<String> res) {
        if (s.length() == idx) {
            if (open == close) {
                if (min > delete) {
                    res.clear();
                    min = delete;
                }
                if (min == delete) {
                    res.add(new String(sb));
                }
            }
            return;
        }
        final char c = s.charAt(idx);
        if (c == '(') {
            dfs(s, sb, open, close, delete + 1, idx + 1, res);
            sb.append('(');
            dfs(s, sb, open + 1, close, delete, idx + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        } else if (c == ')') {
            if (open > close) {
                sb.append(')');
                dfs(s, sb, open, close + 1, delete, idx + 1, res);
                sb.deleteCharAt(sb.length() - 1);
            }
            dfs(s, sb, open, close, delete, idx + 1, res);
        } else {
            sb.append(c);
            dfs(s, sb, open, close, delete + 1, idx + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> removeInvalidParenthesesLVP(String s) {
        int delLeft = 0;
        int delRight = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                delLeft++;
            } else if (c == ')') {
                if (delLeft > 0) {
                    delLeft--;
                } else {
                    delRight++;
                }
            }
        }
        final List<String> res = new ArrayList<>();
        recurse(s, new StringBuilder(), delLeft, delRight, 0, 0, res);
        return res;
    }

    private static void recurse(String s, StringBuilder sb, int open, int close, int delete, int idx,
                                List<String> res) {
        if (idx == s.length() && delete == 0 && open == 0 && close == 0) {
            res.add(sb.toString());
            return;
        }
        if (delete < 0 || open < 0 || close < 0 || idx == s.length()) {
            return;
        }
        final int len = sb.length();
        final char c = s.charAt(idx);
        if (c == '(') {
            recurse(s, sb, open - 1, close, delete, idx + 1, res);
            int rep = 1;
            while (idx + rep < s.length() && s.charAt(idx + rep) == '(') {
                rep++;
            }
            sb.append(s.toCharArray(), idx, rep);
            recurse(s, sb, open, close, delete + rep, idx + rep, res);
            sb.setLength(len);
        } else if (c == ')') {
            recurse(s, sb, open, close - 1, delete, idx + 1, res);
            int rep = 1;
            while (idx + rep < s.length() && s.charAt(idx + rep) == ')') {
                rep++;
            }
            sb.append(s.toCharArray(), idx, rep);
            recurse(s, sb, open, close, delete - rep, idx + rep, res);
            sb.setLength(len);
        } else {
            sb.append(c);
            recurse(s, sb, open, close, delete, idx + 1, res);
            sb.deleteCharAt(len);
        }
    }
}
