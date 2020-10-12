package atcoder.beginner_169;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] split = in.nextLine().split(" ");
        final BigDecimal first = new BigDecimal(split[0]);
        final BigDecimal second = new BigDecimal(split[1]);
        System.out.println(first.multiply(second).setScale(0, RoundingMode.FLOOR));
    }
}
