package atcoder.beginner_100_199.beginner_164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        in.nextLine();
        final Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextLine());
        }
        System.out.println(set.size());
    }
}
