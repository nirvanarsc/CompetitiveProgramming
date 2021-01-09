package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_127 {

    public int ladderLengthBidirectional(String beginWord, String endWord, List<String> wordList) {
        final Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }

        int len = 1;
        Set<String> beginSet = new HashSet<>(Collections.singletonList(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singletonList(endWord));

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                final Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            final Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                final char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        final char old = chars[i];
                        chars[i] = c;
                        final String target = new String(chars);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (words.contains(target)) {
                            temp.add(target);
                            words.remove(target);
                        }
                        chars[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Set<String> dict = new HashSet<>(wordList);
        final Deque<String> q = new ArrayDeque<>();
        q.offerLast(beginWord);
        for (int level = 1; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final String curr = q.removeFirst();
                if (curr.equals(endWord)) {
                    return level;
                }
                final char[] s = curr.toCharArray();
                for (int i = 0; i < s.length; i++) {
                    final char original = s[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != original) {
                            s[i] = c;
                            final String next = new String(s);
                            if (dict.contains(next)) {
                                q.offerLast(next);
                                // instead of an additional "seen" Set
                                dict.remove(next);
                            }
                        }
                    }
                    s[i] = original;
                }
            }
        }
        return 0;
    }
}
