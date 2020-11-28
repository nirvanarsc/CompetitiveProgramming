package codeforces.round_600_649.round_644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            in.nextLine();
            if (k >= n) {
                System.out.println(1);
                continue;
            }
            if (k == 1) {
                System.out.println(n);
                continue;
            }
            final List<Integer> divisors = new ArrayList<>();
            divisors.add(1);
            divisors.add(n);
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    if (n / i == i) {
                        divisors.add(i);
                    } else {
                        divisors.add(i);
                        divisors.add(n / i);
                    }
                }
            }
            divisors.sort(Comparator.naturalOrder());
            System.out.println(n / divisors.get(lowerBound(divisors, k)));
        }
    }

    private static int lowerBound(List<Integer> list, int target) {
        int lo = 0;
        int hi = list.size();
        while (lo <= hi) {
            final int mid = lo + hi >>> 1;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else if (list.get(mid) == target) {
                return mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo - 1;
    }
}
