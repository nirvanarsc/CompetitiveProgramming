public final class FlippingAnImage {

    public static void main(String[] args) {
        final int[][] image1 = {
                new int[]{1, 1, 0, 0},
                new int[]{1, 0, 0, 1},
                new int[]{0, 1, 1, 1},
                new int[]{1, 0, 1, 0}
        };

        final int[][] image2 = {
                new int[]{1, 1, 0},
                new int[]{1, 0, 0},
                new int[]{0, 1, 1},
        };

        printImage(flipAndInvertImage(image1));
        System.out.println();
        printImage(flipAndInvertImage(image2));

    }

    private static int[][] flipAndInvertImage(int[][] a) {
        final int n = a.length;
        for (int[] row : a) {
            for (int i = 0; i * 2 < n; i++) {
                if (row[i] == row[n - i - 1]) {
                    row[i] = row[n - i - 1] ^= 1;
                }
            }
        }
        return a;
    }

    private static void printImage(int[][] a) {
        for (int[] row : a) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
