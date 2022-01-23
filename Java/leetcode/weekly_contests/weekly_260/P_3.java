package leetcode.weekly_contests.weekly_260;

public class P_3 {

    public boolean placeWordInCrossword(char[][] board, String word) {
        final int n = board.length;
        final int m = board[0].length;
        final char[] w = word.toCharArray();
        final char[] revW = new StringBuilder(word).reverse().toString().toCharArray();
        final int wL = w.length;
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != '#') {
                    int k = j;
                    while (k < m && board[i][k] != '#') {
                        k++;
                    }
                    final int L = k - j;
                    if (L == wL) {
                        boolean ok = true;
                        for (int l = 0, r = j; l < wL; l++, r++) {
                            if (board[i][r] != ' ' && board[i][r] != w[l]) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok) {
                            return true;
                        }
                        ok = true;
                        for (int l = 0, r = j; l < wL; l++, r++) {
                            if (board[i][r] != ' ' && board[i][r] != revW[l]) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok) {
                            return true;
                        }
                    }
                    j = k - 1;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (board[i][j] != '#') {
                    int k = i;
                    while (k < n && board[k][j] != '#') {
                        k++;
                    }
                    final int L = k - i;
                    if (L == wL) {
                        boolean ok = true;
                        for (int l = 0, r = i; l < wL; l++, r++) {
                            if (board[r][j] != ' ' && board[r][j] != w[l]) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok) {
                            return true;
                        }
                        ok = true;
                        for (int l = 0, r = i; l < wL; l++, r++) {
                            if (board[r][j] != ' ' && board[r][j] != revW[l]) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok) {
                            return true;
                        }
                    }
                    i = k - 1;
                }
            }
        }
        return false;
    }
}
