package atcoder.beginner_100_199.beginner_170;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int x = in.nextInt();
        final int n = in.nextInt();
        in.nextLine();
        final Set<Integer> set = IntStream.rangeClosed(0, 101).boxed().collect(Collectors.toSet());
        for (int i = 0; i < n; i++) {
            set.remove(in.nextInt());
        }
        int diff = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int item : set) {
            if (Math.abs(item - x) < diff) {
                diff = Math.abs(item - x);
                res = item;
            } else if (Math.abs(item - x) == diff) {
                res = Math.min(res, item);
            }
        }
        System.out.println(res);
    }
}
