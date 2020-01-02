package medium;

import java.util.Deque;
import java.util.LinkedList;

public class P_394 {

    public String decodeString(String s) {
        final Deque<Integer> intStack = new LinkedList<>();
        final Deque<StringBuilder> strStack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
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
