package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P_212 {

    static class Trie {
        Trie[] children = new Trie[26];
        String word;
    }

    char[][] board;
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
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
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                dfs(row, col, root);
            }
        }
        return res;
    }

    @SuppressWarnings("ConstantConditions")
    private void dfs(int row, int col, Trie curr) {
        if (curr != null && curr.word != null) {
            res.add(curr.word);
            curr.word = null;
        }
        if (curr == null
            || row < 0
            || row == board.length
            || col < 0
            || col == board[0].length
            || board[row][col] == '#') {
            return;
        }
        final char letter = board[row][col];
        board[row][col] = '#';
        for (int[] dir : DIRS) {
            dfs(row + dir[0], col + dir[1], curr.children[letter - 'a']);
        }
        board[row][col] = letter;
    }

    public List<String> findWordsBF(char[][] board, String[] words) {
        return Arrays.stream(words)
                     .filter(w -> exist(board, w))
                     .collect(Collectors.toList());
    }

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        final char t = board[i][j];
        board[i][j] = '#';
        for (int[] dir : DIRS) {
            if (dfs(board, i + dir[0], j + dir[1], word, index + 1)) {
                return true;
            }
        }
        board[i][j] = t;
        return false;
    }
}
