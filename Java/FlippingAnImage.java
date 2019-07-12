public class FlippingAnImage {

    public static void main(String[] args) {
        int[][] image1 = new int[][]{
                new int[]{1, 1, 0, 0},
                new int[]{1, 0, 0, 1},
                new int[]{0, 1, 1, 1},
                new int[]{1, 0, 1, 0}
        };

        int[][] image2 = new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 0, 0},
                new int[]{0, 1, 1},
        };

        printImage(flipAndInvertImage(image1));
        System.out.println();
        printImage(flipAndInvertImage(image2));

    }

    private static int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }

    private static void printImage(int[][] A) {
        for (int row[] : A) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
