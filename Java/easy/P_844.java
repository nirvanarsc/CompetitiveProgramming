package easy;

import java.util.Deque;
import java.util.LinkedList;

public class P_844 {

    public boolean backspaceCompareInPlace(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipLeft = 0;
        int skipRight = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (skipLeft > 0 || s.charAt(i) == '#')) {
                if (s.charAt(i) == '#') {
                    skipLeft++;
                } else {
                    skipLeft--;
                }
                i--;
            }
            while (j >= 0 && (skipRight > 0 || t.charAt(j) == '#')) {
                if (t.charAt(j) == '#') {
                    skipRight++;
                } else {
                    skipRight--;
                }
                j--;
            }
            final int left = i >= 0 ? s.charAt(i) : '#';
            final int right = j >= 0 ? t.charAt(j) : '#';
            if (left != right) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public boolean backspaceCompare(String s, String t) {
        final Deque<Character> s1 = new LinkedList<>();
        final Deque<Character> s2 = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!s1.isEmpty()) {
                    s1.removeFirst();
                }
            } else {
                s1.addFirst(c);
            }
        }
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!s2.isEmpty()) {
                    s2.removeFirst();
                }
            } else {
                s2.addFirst(c);
            }
        }
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.removeFirst() != s2.removeFirst()) {
                return false;
            }
        }
        return s1.isEmpty() && s2.isEmpty();
    }
}
