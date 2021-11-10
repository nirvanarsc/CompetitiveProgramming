package leetcode.weekly_contests.weekly_152;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1178 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < (n - 1) && prices[j] >= prices[j + 1]) {
                j++;
            }
            int buy = prices[j];
            while (j < (n - 1) && prices[j] <= prices[j + 1]) {
                j++;
            }
            res += prices[j] - buy;
            i = j;
        }
        return res;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        final Map<Integer, Integer> freq = new HashMap<>();
        for (String w : words) {
            int mask = 0;
            for (char c : w.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            freq.merge(mask, 1, Integer::sum);
        }
        final List<Integer> res = new ArrayList<>(puzzles.length);
        for (String p : puzzles) {
            int mask = 0;
            for (char c : p.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            int curr = 0;
            for (int subMask = mask; subMask > 0; subMask = (subMask - 1) & mask) {
                final Integer inc = freq.get(subMask);
                if (inc != null && (subMask & (1 << p.charAt(0) - 'a')) != 0) {
                    curr += inc;
                }
            }
            res.add(curr);
        }
        return res;
    }

    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        int count;
    }

    public List<Integer> findNumOfValidWordsTrie(String[] words, String[] puzzles) {
        final List<Integer> res = new ArrayList<>();
        final TrieNode root = new TrieNode();
        for (String word : words) {
            build(word, root);
        }
        for (String p : puzzles) {
            final char[] temp = p.toCharArray();
            Arrays.sort(temp);
            res.add(search(temp, 0, root, false, p.charAt(0)));
        }
        return res;
    }

    private static int search(char[] p, int i, TrieNode root, boolean foundFirst, char firstCh) {
        if (root == null) { return 0; }
        int count = 0;
        for (int j = i; j < p.length; j++) {
            final int idx = p[j] - 'a';
            if (firstCh == p[j]) {
                count += search(p, j + 1, root.next[idx], true, firstCh);
            } else {
                count += search(p, j + 1, root.next[idx], foundFirst, firstCh);
            }
        }
        if (foundFirst) {
            count += root.count;
        }
        return count;
    }

    private static void build(String word, TrieNode root) {
        final char[] arr = word.toCharArray();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) { continue; }
            final int idx = arr[i] - 'a';
            if (root.next[idx] == null) {
                root.next[idx] = new TrieNode();
            }
            root = root.next[idx];
        }
        root.count++;
    }
}
