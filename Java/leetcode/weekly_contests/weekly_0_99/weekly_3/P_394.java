package leetcode.weekly_contests.weekly_0_99.weekly_3;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

@SuppressWarnings("StringRepeatCanBeUsed")
public class P_394 {

    public String decodeString(String s) {
        final Deque<StringBuilder> strings = new ArrayDeque<>(Collections.singleton(new StringBuilder()));
        final Deque<Integer> count = new ArrayDeque<>();
        final char[] chars = s.toCharArray();
        final int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(chars[i])) {
                int num = 0;
                int j = i;
                while (j < n && Character.isDigit(chars[j])) {
                    num = num * 10 + chars[j] - '0';
                    j++;
                }
                i = j - 1;
                count.addFirst(num);
            } else if (chars[i] == '[') {
                strings.addFirst(new StringBuilder());
            } else if (chars[i] == ']') {
                final StringBuilder first = strings.removeFirst();
                final StringBuilder second = strings.getFirst();
                final int k = count.removeFirst();
                for (int j = 0; j < k; j++) {
                    second.append(first);
                }
            } else {
                strings.getFirst().append(chars[i]);
            }
        }
        return strings.getFirst().toString();
    }
}
