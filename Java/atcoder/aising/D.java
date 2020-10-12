package atcoder.aising;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final String num = in.nextLine();
        int bitCount = 0;
        for (int i = 0; i < n; i++) {
            bitCount += num.charAt(i) == '1' ? 1 : 0;
        }
        if (bitCount == 1) {
            for (int i = 0; i < n; i++) {
                if (num.charAt(i) == '1') {
                    System.out.println(0);
                } else {
                    if (i == n - 1 || num.charAt(n - 1) == '1') {
                        System.out.println(2);
                    } else {
                        System.out.println(1);
                    }
                }
            }
            return;
        }
        final long[] plusOne = new long[n];
        final long[] minusOne = new long[n];
        long tempPlusOne = 0;
        long tempMinusOne = 0;
        long runningPlus = 1;
        long runningMinus = 1;
        for (int i = n - 1; i >= 0; i--) {
            plusOne[i] = runningPlus;
            minusOne[i] = runningMinus;
            if (num.charAt(i) == '1') {
                tempPlusOne += runningPlus;
                tempMinusOne += runningMinus;
            }
            runningPlus = (runningPlus * 2) % (bitCount + 1);
            runningMinus = (runningMinus * 2) % (bitCount - 1);
        }
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '0') {
                System.out.println(f((tempPlusOne + plusOne[i]) % (bitCount + 1)));
            } else {
                System.out.println(f((tempMinusOne - minusOne[i]) % (bitCount - 1)));
            }
        }
    }

    private static int f(long n) {
        int res = 1;
        while (n > 0) {
            n %= Long.bitCount(n);
            res++;
        }
        return res;
    }
}
