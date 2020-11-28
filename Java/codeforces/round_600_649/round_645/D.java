package codeforces.round_600_649.round_645;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class D {

    private static long f(long x) {
        return (x * (x + 1)) / 2;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final long x = in.nextLong();
        final long[] days = new long[2 * n];
        for (int i = 0; i < n; i++) {
            days[i] = days[i + n] = in.nextInt();
        }
        in.nextLine();
        int j = 0;
        long res = 0, countDays = 0, countHugs = 0;
        for (long day : days) {
            countDays += day;
            countHugs += f(day);
            while (countDays - days[j] >= x) {
                countDays -= days[j];
                countHugs -= f(days[j++]);
            }
            res = Math.max(res, countHugs - f(Math.max(0, countDays - x)));
        }
        System.out.println(res);
    }
}
