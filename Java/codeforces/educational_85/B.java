package codeforces.educational_85;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int d = in.nextInt();
            in.nextLine();
            final List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }
            in.nextLine();
            list.sort(Collections.reverseOrder());
            double sum = 0;
            int cnt = 1;
            for (int i = 0; i < list.size(); i++, cnt++) {
                sum += list.get(i);
                if (sum / cnt < d) {
                    break;
                }
            }
            System.out.println(cnt - 1);
        }
    }
}
