import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class NQueensII {

    public static int totalNQueens(int n) {
        final AtomicInteger res = new AtomicInteger();
        recurse(0, n, res, new ArrayList<>());
        return res.get();
    }

    private static void recurse(int row, int n, AtomicInteger res, List<Integer> currSolution) {
        if (row == n) {
            res.incrementAndGet();
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

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueens(5));
    }

    private NQueensII() {}
}
