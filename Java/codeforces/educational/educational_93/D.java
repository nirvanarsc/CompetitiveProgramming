package codeforces.educational.educational_93;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line = in.nextLine().split(" ");
        final int r = Integer.parseInt(line[0]);
        final int g = Integer.parseInt(line[1]);
        final int b = Integer.parseInt(line[2]);
        final int[] red = new int[r];
        final int[] green = new int[g];
        final int[] blue = new int[b];
        for (int i = 0; i < r; i++) {
            red[i] = in.nextInt();
        }
        in.nextLine();
        for (int i = 0; i < g; i++) {
            green[i] = in.nextInt();
        }
        in.nextLine();
        for (int i = 0; i < b; i++) {
            blue[i] = in.nextInt();
        }
        in.nextLine();
        Arrays.sort(red);
        Arrays.sort(green);
        Arrays.sort(blue);
        reverse(0, red.length - 1, red);
        reverse(0, green.length - 1, green);
        reverse(0, blue.length - 1, blue);
        System.out.println(dfs(red, green, blue, 0, 0, 0, new Long[r + 1][g + 1][b + 1]));
    }

    private static long dfs(int[] red, int[] green, int[] blue, int r, int g, int b, Long[][][] dp) {
        if ((r == red.length ? 1 : 0) + (g == green.length ? 1 : 0) + (b == blue.length ? 1 : 0) >= 2) {
            return 0;
        }
        if (dp[r][g][b] != null) {
            return dp[r][g][b];
        }
        long rg = 0;
        long rb = 0;
        long gb = 0;
        if (r < red.length && g < green.length) {
            rg = (long) red[r] * green[g] + dfs(red, green, blue, r + 1, g + 1, b, dp);
        }
        if (r < red.length && b < blue.length) {
            rb = (long) red[r] * blue[b] + dfs(red, green, blue, r + 1, g, b + 1, dp);
        }
        if (g < green.length && b < blue.length) {
            gb = (long) green[g] * blue[b] + dfs(red, green, blue, r, g + 1, b + 1, dp);
        }
        return dp[r][g][b] = Math.max(rg, Math.max(rb, gb));
    }

    private static void reverse(int from, int to, int[] arr) {
        for (int i = from; 2 * i < to + from; i++) {
            final int temp = arr[i];
            arr[i] = arr[to + from - i];
            arr[to + from - i] = temp;
        }
    }
}
