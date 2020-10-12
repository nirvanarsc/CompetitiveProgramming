package leetcode.weekly_contests.weekly_3;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_394 {

    public String decodeString(String s) {
        final Deque<Integer> intStack = new ArrayDeque<>();
        final Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + Character.getNumericValue(ch);
            } else if (ch == '[') {
                intStack.addFirst(k);
                strStack.addFirst(res);
                res = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                final StringBuilder tmp = res;
                res = strStack.removeFirst();
                int count = intStack.removeFirst();
                while (count-- > 0) {
                    res.append(tmp);
                }
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
