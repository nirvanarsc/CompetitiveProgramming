package gcj.qualifying;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public final class Indicium {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = in.nextInt();
            final int trace = in.nextInt();
            final int[] arr = IntStream.rangeClosed(1, n).toArray();
            final List<List<Integer>> possibleDiagonals = combinationSum(arr, trace, n);
            String res = "IMPOSSIBLE";
            int[][] m = null;
            for (List<Integer> d : possibleDiagonals) {
                final int[][] backtrack = backtrack(d, n);
                if (backtrack != null) {
                    res = "POSSIBLE";
                    m = backtrack;
                    break;
                }
            }
            System.out.println("Case #" + x + ": " + res);
            if (res == "POSSIBLE") {
                for (int[] row : m) {
                    for (int num : row) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target, int size) {
        final List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        recurse(candidates, 0, target, size, new ArrayList<>(), res);
        return res;
    }

    private Indicium() {}

    private static void recurse(int[] candidates,
                                int start,
                                int target,
                                int size,
                                List<Integer> curr,
                                List<List<Integer>> res) {
        if (target == 0 && curr.size() == size) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            curr.add(candidates[i]);
            recurse(candidates, i, target - candidates[i], size, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    @SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
    private static int[][] backtrack(List<Integer> diagonal, int n) {
        final int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = diagonal.get(i);
        }
        if (solve(matrix, n)) {
            return matrix;
        }
        return null;
    }

    public static boolean solve(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    for (char k = 1; k <= n; k++) {
                        if (isValid(board, i, j, k, n)) {
                            board[i][j] = k;
                            if (solve(board, n)) {
                                return true;
                            }
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int r, int c, int k, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i][c] != 0 && board[i][c] == k) {
                return false;
            }
            if (board[r][i] != 0 && board[r][i] == k) {
                return false;
            }
        }
        return true;
    }
}
