package biweekly_contests.biweekly_15;

public final class P_1289 {

    public static int minFallingPathSum(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int col = 0; col < arr[0].length; col++) {
                arr[i][col] += minWithoutCol(arr[i - 1], col);
            }
        }

        return minWithoutCol(arr[arr.length - 1], -1);
    }

    private static int minWithoutCol(int[] row, int ignoredCol) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row.length; i++) {
            if (i != ignoredCol) {
                min = Math.min(min, row[i]);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        }));
    }

    private P_1289() {}
}
