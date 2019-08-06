public final class TransposeMatrix {

    public static void main(String[] args) {
        for (int[] row : transpose(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } })) {
            for (int i : row) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] a) {
        final int[][] res = new int[a[0].length][a.length];

        for (int r = 0; r < a[0].length; r++) {
            for (int c = 0; c < a.length; c++) {
                res[r][c] = a[c][r];
            }
        }

        return res;
    }

    private TransposeMatrix() {}
}
