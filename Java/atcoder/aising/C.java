package atcoder.aising;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final Map<Integer, Integer> squares = new HashMap<>();
        for (int i = 1; i <= 150; i++) {
            for (int j = 1; j <= 150; j++) {
                for (int k = 1; k <= 150; k++) {
                    squares.merge((i + j) * (i + j) + (i + k) * (i + k) + (j + k) * (j + k), 1, Integer::sum);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(squares.getOrDefault(2 * i, 0));
        }
    }
}
