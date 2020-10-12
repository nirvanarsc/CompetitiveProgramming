package atcoder.tokio_marine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String name = in.nextLine();
        System.out.println(name.substring(0, 3));
    }
}
