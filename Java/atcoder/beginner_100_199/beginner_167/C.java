package atcoder.beginner_100_199.beginner_167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int m = in.nextInt();
        final int x = in.nextInt();
        in.nextLine();
        final int[][] books = new int[n][m + 1];
        final int[] max = new int[m];
        for (int i = 0; i < n; i++) {
            final int[] book = new int[m + 1];
            for (int z = 0; z < m + 1; z++) {
                book[z] = in.nextInt();
                if (z > 0) {
                    max[z - 1] += book[z];
                }
            }
            in.nextLine();
            books[i] = book;
        }
        if (Arrays.stream(max).anyMatch(skill -> skill < x)) {
            System.out.println(-1);
            return;
        }
        final int[] res = { (int) 1e9 };
        knapsack(books, new int[m], x, 0, 0, res);
        System.out.println(res[0]);
    }

    private static void knapsack(int[][] books, int[] pick, int x, int i, int cost, int[] res) {
        if (i == books.length) {
            if (Arrays.stream(pick).noneMatch(skill -> skill < x)) {
                res[0] = Math.min(res[0], cost);
            }
            return;
        }
        for (int z = 1; z < books[i].length; z++) {
            pick[z - 1] += books[i][z];
        }
        knapsack(books, pick, x, i + 1, cost + books[i][0], res);
        for (int z = 1; z < books[i].length; z++) {
            pick[z - 1] -= books[i][z];
        }
        knapsack(books, pick, x, i + 1, cost, res);
    }
}
