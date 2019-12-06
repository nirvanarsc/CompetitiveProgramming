import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        final List<List<String>> res = new ArrayList<>();
        recurse(0, n, res, new ArrayList<>());
        return res;
    }

    private static void recurse(int row, int n, List<List<String>> res, List<Integer> currSolution) {
        if (row == n) {
            res.add(new ArrayList<>(currSolution.stream()
                                                .map(i -> toString(i, n))
                                                .collect(Collectors.toList())));
        }

        for (int i = 0; i < n; i++) {
            currSolution.add(i);
            if (isValid(row, currSolution)) {
                recurse(row + 1, n, res, currSolution);
            }
            currSolution.remove(currSolution.size() - 1);
        }
    }

    private static boolean isValid(int row, List<Integer> placement) {
        for (int i = 0; i < row; i++) {
            final int diff = Math.abs(placement.get(i) - placement.get(row));
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }

    private static String toString(int k, int n) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(i == k ? 'Q' : '.');
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(5));
    }

    private NQueens() {}
}
