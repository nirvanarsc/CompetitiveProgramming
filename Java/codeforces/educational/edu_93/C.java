package codeforces.educational.edu_93;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final String s = in.nextLine();
            final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, 1));
            int sum = 0;
            long res = 0;
            for (int i = 0; i < n; i++) {
                sum += s.charAt(i) - '0' - 1;
                res += map.getOrDefault(sum, 0);
                map.merge(sum, 1, Integer::sum);
            }
            System.out.println(res);
        }
    }
}
