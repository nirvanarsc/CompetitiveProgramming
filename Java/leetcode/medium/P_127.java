package leetcode.medium;

import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
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

    public static int ladderLengthBFS(String beginWord, String endWord, List<String> wordList) {
        final Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }

        final Deque<String> queue = new LinkedList<>();
        queue.offerLast(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize-- > 0) {
                final String curr = queue.removeFirst();
                final char[] chars = curr.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    final char ch = chars[i];
                    for (char newChar = 'a'; newChar <= 'z'; newChar++) {
                        if (newChar == ch) {
                            continue;
                        }
                        chars[i] = newChar;
                        final String tmp = new String(chars);
                        if (tmp.equals(endWord)) {
                            return level + 1;
                        }
                        if (words.contains(tmp)) {
                            queue.offerLast(tmp);
                            words.remove(tmp);
                        }
                    }
                    chars[i] = ch;
                }
            }
            level++;
        }
        return 0;
    }
}
