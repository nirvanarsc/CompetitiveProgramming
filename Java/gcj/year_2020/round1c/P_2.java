package gcj.year_2020.round1c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public final class P_2 {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final CurrProblem solver = new CurrProblem();
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            System.out.printf("Case #%d: %s\n", x, solver.solve(in));
        }
    }

    static class CurrProblem {
        public String solve(Scanner in) {
            final int u = in.nextInt();
            in.nextLine();
            final Map<Character, Integer> freq = new HashMap<>();
            final Set<Character> all = new HashSet<>();
            for (int i = 0; i < 10000; i++) {
                final String[] s = in.nextLine().split(" ");
                freq.merge(s[1].charAt(0), 1, Integer::sum);
                for (char c : s[1].toCharArray()) {
                    all.add(c);
                }
            }
            all.removeAll(freq.keySet());
            freq.put(all.iterator().next(), Integer.MAX_VALUE);
            return freq
                    .entrySet()
                    .stream()
                    .sorted((x, y) -> Integer.compare(y.getValue(), x.getValue()))
                    .map(x -> String.valueOf(x.getKey()))
                    .collect(Collectors.joining());
        }
    }
}
