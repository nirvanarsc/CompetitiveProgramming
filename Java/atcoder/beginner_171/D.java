package atcoder.beginner_171;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final Map<Integer, Integer> freq = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            final int curr = in.nextInt();
            sum += curr;
            freq.merge(curr, 1, Integer::sum);
        }
        in.nextLine();
        final int q = Integer.parseInt(in.nextLine());
        for (int i = 0; i < q; i++) {
            final int num = in.nextInt();
            final int val = in.nextInt();
            if (freq.containsKey(num)) {
                final int count = freq.remove(num);
                sum += (long) count * (val - num);
                freq.merge(val, count, Integer::sum);
            }
            System.out.println(sum);
        }
    }
}
