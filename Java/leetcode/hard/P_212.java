package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class P_212 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    static class Trie {
        Trie[] children = new Trie[26];
        String word;
    }

    static char[][] g;
    static List<String> res;
    static int n;
    static int m;

    public List<String> findWords(char[][] board, String[] words) {
        g = board;
        res = new ArrayList<>();
        n = board.length;
        m = board[0].length;
        final Trie root = new Trie();
        for (String word : words) {
            Trie iter = root;
            for (char letter : word.toCharArray()) {
                if (iter.children[letter - 'a'] == null) {
                    iter.children[letter - 'a'] = new Trie();
                }
                iter = iter.children[letter - 'a'];
            }
            iter.word = word;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, root);
            }
        }
        return res;
    }

    private static void dfs(int row, int col, Trie curr) {
        if (curr != null && curr.word != null) {
            res.add(curr.word);
            //noinspection ConstantConditions
            curr.word = null;
        }
        if (curr == null || row < 0 || row == n || col < 0 || col == m || g[row][col] == '#') {
            return;
        }
        final char letter = g[row][col];
        g[row][col] = '#';
        for (int[] dir : DIRS) {
            dfs(row + dir[0], col + dir[1], curr.children[letter - 'a']);
        }
        g[row][col] = letter;
    }
}
