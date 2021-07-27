package codeforces.global.global_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class E {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        final List<Integer> idx = IntStream.rangeClosed(1, n)
                                           .boxed()
                                           .sorted(Comparator.comparingInt(a -> arr[a - 1]))
                                           .collect(Collectors.toList());
        int m = 0;
        final StringBuilder out = new StringBuilder();
        final List<Integer> list = new ArrayList<>();
        for (int j : idx) {
            for (int k = 0; k < list.size(); k++) {
                if (list.get(k) < j) {
                    list.add(k, j);
                    break;
                } else {
                    m++;
                    out.append(j + " " + list.get(k) + '\n');
                }
            }
            if (list.isEmpty() || list.get(list.size() - 1) > j) {
                list.add(j);
            }
        }
        System.out.println(m);
        System.out.println(out);
    }
}
