package leetcode.biweekly_contests.biweekly_100_199.biweekly_139;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P_3 {

    static class Trie {
        Trie[] children = new Trie[10];
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        final Trie root = new Trie();
        for (int num : arr2) {
            add(root, String.valueOf(num));
        }
        int res = 0;
        for (int num : arr1) {
            res = Math.max(res, f(root, String.valueOf(num)));
        }
        return res;
    }

    private static void add(Trie root, String w) {
        Trie iter = root;
        for (char c : w.toCharArray()) {
            if (iter.children[c - '0'] == null) {
                iter.children[c - '0'] = new Trie();
            }
            iter = iter.children[c - '0'];
        }
    }

    private static int f(Trie root, String w) {
        Trie iter = root;
        final char[] s = w.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (iter.children[s[i] - '0'] == null) {
                return i;
            }
            iter = iter.children[s[i] - '0'];
        }
        return s.length;
    }

    public int maxValue(int[] nums, int k) {
        final List<String> s = new ArrayList<>();
        for (int num : nums) {
            s.add(f(num));
        }
        s.sort(Comparator.naturalOrder());
        System.out.println(s);
        final int l = f2(s, k);
        Collections.reverse(s);
        final int r = f2(s, k);
        return l ^ r;
    }

    public static void main(String[] args) {
        System.out.println(String.format("%7s", Integer.toBinaryString(1)).replace(' ', '0'));

    }

    private static String f(int n) {
        return String.format("%7s", Integer.toBinaryString(n)).replace(' ', '0');
    }

    private static int f2(List<String> s, int k) {
        int res = 0;
        for (int i = 0; i < k; i++) {
            res |= Integer.parseInt(s.get(i), 2);
        }
        return res;
    }
}
