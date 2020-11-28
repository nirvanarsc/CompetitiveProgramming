package codeforces.educational.educational_93;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final StringBuilder s = new StringBuilder();
            s.append('0');
            s.append(in.nextLine());
            s.append('0');
            final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    int j = i;
                    while (s.charAt(j) == '1') {
                        j++;
                    }
                    pq.add(j - i);
                    i = j;
                }
            }
            int res = 0;
            while (pq.size() > 1) {
                res += pq.remove();
                pq.remove();
            }
            if (!pq.isEmpty()) {
                res += pq.remove();
            }
            System.out.println(res);
        }
    }
}
