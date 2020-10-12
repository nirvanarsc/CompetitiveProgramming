package atcoder.m_solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int a = in.nextInt();
        final int b = in.nextInt();
        final int c = in.nextInt();
        in.nextLine();
        final int k = Integer.parseInt(in.nextLine());
        System.out.println(dfs(a, b, c, k) ? "Yes" : "No");
    }

    private static boolean dfs(int a, int b, int c, int k) {
        if (k == 0) {
            return c > b && b > a;
        }
        return dfs(a * 2, b, c, k - 1) || dfs(a, b * 2, c, k - 1) || dfs(a, b, c * 2, k - 1);
    }
}
