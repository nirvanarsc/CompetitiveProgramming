package codeforces.round_662;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final int[] count = new int[(int) 1e5 + 1];
        for (int i = 0; i < n; i++) {
            count[in.nextInt()]++;
        }
        in.nextLine();
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int value : count) {
            if (value != 0) {
                map.merge(value, 1, Integer::sum);
            }
        }
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String[] line = in.nextLine().split(" ");
            final int diff = Integer.parseInt(line[1]);
            if ("+".equals(line[0])) {
                map.merge(count[diff], -1, Integer::sum);
                if (map.get(count[diff]) == 0) {
                    map.remove(count[diff]);
                }
                count[diff] += 1;
                map.merge(count[diff], 1, Integer::sum);
            } else {
                map.merge(count[diff], -1, Integer::sum);
                if (map.get(count[diff]) == 0) {
                    map.remove(count[diff]);
                }
                count[diff] -= 1;
                if (count[diff] > 0) {
                    map.merge(count[diff], 1, Integer::sum);
                }
            }
            // Not descending iterator!!!
            final Iterator<Map.Entry<Integer, Integer>> iterator = map.descendingMap().entrySet().iterator();
            int morethan2 = 0;
            int morethan4 = 0;
            for (int i = 0; i < 3 && iterator.hasNext(); i++) {
                final Map.Entry<Integer, Integer> curr = iterator.next();
                final int freq = curr.getKey();
                final int freqCount = curr.getValue();
                if (freq >= 8) {
                    morethan4 += 2 * freqCount;
                } else if (freq >= 6) {
                    morethan4 += freqCount;
                    morethan2 += freqCount;
                } else if (freq >= 4) {
                    morethan4 += freqCount;
                } else if (freq >= 2) {
                    morethan2 += freqCount;
                }
            }
            if (morethan4 >= 2 || morethan4 >= 1 && morethan2 >= 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
