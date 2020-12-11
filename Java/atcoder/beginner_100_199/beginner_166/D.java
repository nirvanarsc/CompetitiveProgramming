package atcoder.beginner_100_199.beginner_166;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int x = in.nextInt();
        int t = 0;
        final Map<Long, Integer> map = new HashMap<>();
        while (Math.pow(t, 5) < 1e18) {
            map.put((long) Math.pow(t, 5), t);
            map.put((long) Math.pow(-t, 5), -t);
            t++;
        }
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (map.containsKey(x + entry.getKey())) {
                System.out.println(map.get(x + entry.getKey()) + " " + entry.getValue());
                return;
            }
        }
    }
}
