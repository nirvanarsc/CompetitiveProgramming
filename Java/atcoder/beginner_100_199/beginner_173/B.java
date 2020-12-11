package atcoder.beginner_100_199.beginner_173;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(in.nextLine(), 1, Integer::sum);
        }
        System.out.println("AC x " + map.getOrDefault("AC", 0));
        System.out.println("WA x " + map.getOrDefault("WA", 0));
        System.out.println("TLE x " + map.getOrDefault("TLE", 0));
        System.out.println("RE x " + map.getOrDefault("RE", 0));
    }
}
