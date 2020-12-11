package atcoder.beginner_100_199.beginner_171;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int k = in.nextInt();
        in.nextLine();
        final int[] array = Arrays.stream(in.nextLine().split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .sorted()
                                  .toArray();
        int p = 0;
        for (int i = 0; i < k; i++) {
            p += array[i];
        }
        System.out.println(p);
    }
}
